package org.springframework.ai.openai.samples.helloworld.review.controller.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewForm {

    String review;

    public static String from(String review){
        return "당신은 대학교를 다니고 있는 대학생입니다. 앞으로 주어질 수강 후기 요약본은 당신이 들은 강의들의 후기이며, 이 강의들을 들으면서 느낀점들을 적어두었습니다. 당신의 임무는 수강 후기 요약본에서 자주 등장하는 키워드 1개를 선정하는 것입니다. 키워드 1개를 선정하여 단어 형태로 제시하세요. 그리고 그 키워드의 자주 등장한 점수를 5점만점에 점수를 만들어서 [키워드, 점수] 배열의 형태로 답변하시오. 키워드는 단어만 제시하고 따옴표붙이지말고, 점수는 숫자만 제시하시오."+
                "수강 후기 요약본 : " + review ;
    }




}
