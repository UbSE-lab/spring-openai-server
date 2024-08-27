package org.springframework.ai.openai.samples.helloworld.keyword.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.samples.helloworld.keyword.entity.Keyword;
import org.springframework.ai.openai.samples.helloworld.keyword.infrastructure.KeywordRepository;
import org.springframework.ai.openai.samples.helloworld.review.entity.Lecture;
import org.springframework.ai.openai.samples.helloworld.review.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeywordService {

    private final KeywordRepository keywordRepository;

    private final ReviewService reviewService;

    public Keyword get(Long lectureId){
        Lecture lecture = reviewService.findById(lectureId);

        Keyword keyword = keywordRepository.findByLectureId(lecture.getLectureId());
        return keyword;

    }


}