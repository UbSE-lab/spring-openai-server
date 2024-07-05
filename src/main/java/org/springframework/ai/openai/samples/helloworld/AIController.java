package org.springframework.ai.openai.samples.helloworld;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
class AIController {
	private final ChatClient chatClient;

	AIController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}
	@GetMapping("/ai")
	Map<String, String> completion(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {




		String response1 =
				chatClient.prompt()
						.options(OpenAiChatOptions.builder().withModel("gpt-4o").build())
						.user(
								"당신의 임무 수강 후기 글들을 요약하여 키워드 추출을 도울 수 있는 요약본을 만드는 것입니다." +
										"글 끝마다 콤마로 묶어서 수강 후기 글들을 최대한 핵심 단어들로 요약하되 강의를 어떻게 가르치고, 강의를 들으면서 이해하기 어려웠던 부분은 어떤 것이고, 강의를 들으며 어떤게 해결되었는지를 중점을 두어 요약하십시오."+
										"수강 후기 글: "+message
						)
						.call()
						.content();

		return Map.of(
				"completion",
				chatClient.prompt()
						.options(OpenAiChatOptions.builder().withModel("gpt-4o").build())
						.user(
								"당신은 대학교를 다니고 있는 대학생입니다. 앞으로 주어질 수강 후기 요약본은 당신이 들은 강의들의 후기이며, 이 강의들을 들으면서 느낀점들을 적어두었습니다. 당신의 임무는 수강 후기 요약본에서 자주 등장하는 키워드 1개를 선정하는 것입니다. 키워드 1개를 선정하여 단어 형태로 제시하세요."+
								"수강 후기 요약본 : " + response1

						)
						.call()
						.content());

	}
}
