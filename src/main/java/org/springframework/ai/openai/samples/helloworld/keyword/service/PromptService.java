package org.springframework.ai.openai.samples.helloworld.keyword.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.samples.helloworld.keyword.entity.ChatSession;
import org.springframework.ai.openai.samples.helloworld.keyword.entity.Keyword;
import org.springframework.ai.openai.samples.helloworld.keyword.infrastructure.KeywordRepository;
import org.springframework.ai.openai.samples.helloworld.review.controller.data.ReviewForm;
import org.springframework.ai.openai.samples.helloworld.keyword.infrastructure.ChatSessionRepository;
import org.springframework.ai.openai.samples.helloworld.review.service.ReviewService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PromptService {

    private final ChatSessionRepository chatSessionRepository;

    private final ChatClient chatClient;

    private final ReviewService reviewService;

    private final KeywordRepository keywordRepository;


    // 수강후기들 요약받기 -> 키워드 뽑기 -> db 저장
    public void KeywordAnalysis(Long lectureId){

        String keyword = Completion(lectureId);
        List<String> list = List.of(keyword.replaceAll("[\\['\\]]", "").split(","));
        keywordRepository.save(Keyword.toEntity(list.get(0), lectureId, list.get(1)));
    }

    @Transactional
    public String Completion(Long lectureId){

        String answer = ReviewForm.from(reviewService.ReviewPrompting(lectureId));

        ChatResponse assistant = chatClient.prompt()
                .options(OpenAiChatOptions.builder().withModel("gpt-4o").build())
                .user(answer)
                .call()
                .chatResponse();

        log.info("content: {}", assistant.getResult().getOutput().getContent());

        chatSessionRepository.save(ChatSession.toEntity(answer, assistant.getResult().getOutput().getContent()));

        return assistant.getResult().getOutput().getContent();

    }


}
