package org.springframework.ai.openai.samples.helloworld.keyword.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.samples.helloworld.keyword.dto.KeywordInfo;
import org.springframework.ai.openai.samples.helloworld.keyword.dto.KeywordRequest;
import org.springframework.ai.openai.samples.helloworld.keyword.entity.Keyword;
import org.springframework.ai.openai.samples.helloworld.keyword.service.KeywordService;
import org.springframework.ai.openai.samples.helloworld.keyword.service.PromptService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class KeywordController {

    private final PromptService promptService;

    private final KeywordService keywordService;

    @PostMapping("/completion")
    public String completion(@RequestParam("lectureId") Long lectureId){
        promptService.KeywordAnalysis(lectureId);
        return "분석완료";
    }

    @GetMapping("/keyword")
    public Keyword get(@RequestParam("lectureId") Long lectureId){
        return keywordService.get(lectureId);
    }




}
