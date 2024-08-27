package org.springframework.ai.openai.samples.helloworld.keyword.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.samples.helloworld.review.controller.data.ReviewInfo;

@Data
@AllArgsConstructor
public class PromptForm {

    private String uuid;
    private String message;


        // 요약
        public static String from(String review){
            return "당신의 임무 수강 후기 글들을 요약하여 키워드 추출을 도울 수 있는 요약본을 만드는 것입니다." +
                    "글 끝마다 콤마로 묶어서 수강 후기 글들을 최대한 핵심 단어들로 요약하되 강의를 어떻게 가르치고, 강의를 들으면서 이해하기 어려웠던 부분은 어떤 것이고, 강의를 들으며 어떤게 해결되었는지를 중점을 두어 요약하십시오."+
                    "수강 후기 글: "+ review;
    }





}
