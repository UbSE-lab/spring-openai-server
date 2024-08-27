package org.springframework.ai.openai.samples.helloworld.keyword.entity;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Builder
public class Keyword {


    @Id
    @Column(nullable = false)
    private Long lectureId;

    @Column(nullable = false )
    private String keyword;

    @Column(nullable = false)
    private String score;

    public static Keyword toEntity(String keyword, Long lectureId, String score){
        return Keyword.builder()
                .keyword(keyword)
                .lectureId(lectureId)
                .score(score)
                .build();
    }

}
