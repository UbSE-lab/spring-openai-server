package org.springframework.ai.openai.samples.helloworld.keyword.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class PromptInfo {

    private String uuid;
    private String answer;

    public static PromptInfo from(String answer){

        String uuid = UUID.randomUUID().toString();
        return new PromptInfo(uuid, answer);

    }



}
