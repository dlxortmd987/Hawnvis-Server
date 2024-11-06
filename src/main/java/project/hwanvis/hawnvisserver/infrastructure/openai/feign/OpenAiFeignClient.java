package project.hwanvis.hawnvisserver.infrastructure.openai.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import project.hwanvis.hawnvisserver.infrastructure.openai.dto.OpenAiChatRequest;
import project.hwanvis.hawnvisserver.infrastructure.openai.dto.OpenAiChatResponse;

@FeignClient(name = "${feign.openai.name}", url = "${feign.openai.url")
public interface OpenAiFeignClient {
    @PostMapping("/v1/chat/completions")
    OpenAiChatResponse chat(
            @RequestHeader("Authorization") String apiKey,
            @RequestBody OpenAiChatRequest request
    );
}
