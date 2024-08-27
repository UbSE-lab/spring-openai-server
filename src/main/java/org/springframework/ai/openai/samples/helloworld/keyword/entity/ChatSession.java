package org.springframework.ai.openai.samples.helloworld.keyword.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatSession {


    @Id
    private String uuid;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String userMessage;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String answer;

    public static ChatSession toEntity(String userMessage, String answer){

        return ChatSession.builder()
                .uuid(UUID.randomUUID().toString())
                .userMessage(userMessage)
                .answer(answer)
                .build();

    }

}
