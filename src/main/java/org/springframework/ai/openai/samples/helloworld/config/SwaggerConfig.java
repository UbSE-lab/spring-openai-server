package org.springframework.ai.openai.samples.helloworld.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * localhost:9000/swagger-ui/index.html/
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }



    private Info apiInfo(){
        return new Info()
                .title("class review site prompt api")
                .description("수업리뷰사이트 프롬프트 api docs입니다.")
                .version("1.0.0");
    }
}