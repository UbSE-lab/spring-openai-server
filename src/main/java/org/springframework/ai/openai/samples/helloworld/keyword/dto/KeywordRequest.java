package org.springframework.ai.openai.samples.helloworld.keyword.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class KeywordRequest {

    private Long lectureId;

}
