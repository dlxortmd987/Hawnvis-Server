package project.hwanvis.hawnvisserver.infrastructure.claude.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import project.hwanvis.hawnvisserver.infrastructure.claude.dto.ClaudeChatRequest;
import project.hwanvis.hawnvisserver.infrastructure.claude.dto.ClaudeChatResponse;

@FeignClient(name = "${feign.claude.name}", url = "${feign.claude.url")
public interface ClaudeFeignClient {
    @PostMapping("/v1/messages")
    ClaudeChatResponse chat(
            @RequestHeader("x-api-key") String apiKey,
            @RequestHeader("anthropic-version") String version,
            @RequestBody ClaudeChatRequest request
    );
}
