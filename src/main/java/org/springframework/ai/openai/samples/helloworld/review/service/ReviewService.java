package org.springframework.ai.openai.samples.helloworld.review.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.samples.helloworld.keyword.dto.PromptForm;
import org.springframework.ai.openai.samples.helloworld.review.controller.data.ReviewInfo;
import org.springframework.ai.openai.samples.helloworld.review.entity.ClassReview;
import org.springframework.ai.openai.samples.helloworld.review.entity.Lecture;
import org.springframework.ai.openai.samples.helloworld.review.infrastructure.ClassReviewRepository;
import org.springframework.ai.openai.samples.helloworld.review.infrastructure.LectureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {

    private final ClassReviewRepository classReviewRepository;

    private final LectureRepository lectureRepository;

    private final ChatClient chatClient;


    public List<ClassReview> findAll(){
        return classReviewRepository.findAll();
    }

    public Lecture findById(Long lecutreId){
        return lectureRepository.findById(lecutreId).get();
    }

    public List<ClassReview> findAllByLectureId(Long lecutureId){
        Lecture lecture = findById(lecutureId);
        return classReviewRepository.findAllByLecId(lecture);
    }

    // 요약
    public String ReviewPrompting(Long lectureId){
        return chatClient.prompt()
                        .options(OpenAiChatOptions.builder().withModel("gpt-4o").build())
                        .user(
                            PromptForm.from(ReviewInfo.review(ReviewInfo.toList(findAllByLectureId(lectureId))))
                        )
                        .call()
                        .chatResponse()
                        .getResult().getOutput().getContent();

    }

}
