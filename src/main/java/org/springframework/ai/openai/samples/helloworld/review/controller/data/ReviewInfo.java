package org.springframework.ai.openai.samples.helloworld.review.controller.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.ai.openai.samples.helloworld.review.entity.ClassReview;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ReviewInfo {

    private String title;

    private String content;

    public static String review(List<ReviewInfo> list){
        String form = "";
        for(ReviewInfo info: list){
             form += "제목 : " + info.title + "\n" +"내용: "+ info.content;
        }
        return form;
    }


    public static List<ReviewInfo> toList(List<ClassReview> reviews){
        List<ReviewInfo> list = new ArrayList<>();
        for(ClassReview review : reviews){
            list.add(
                    ReviewInfo.from(review)
            );
        }
        return list;
    }

    public static ReviewInfo from(ClassReview review){
        return new ReviewInfo(
                review.getPostTitle(),
                review.getPostContent()
        );
    }

}
