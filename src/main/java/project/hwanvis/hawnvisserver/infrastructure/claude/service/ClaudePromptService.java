package project.hwanvis.hawnvisserver.infrastructure.claude.service;

import org.springframework.stereotype.Component;
import project.hwanvis.hawnvisserver.controller.dto.CreatePromptRequest;
import project.hwanvis.hawnvisserver.controller.dto.CreatePromptResponse;
import project.hwanvis.hawnvisserver.domain.Vendor;
import project.hwanvis.hawnvisserver.infrastructure.claude.config.ClaudeProperties;
import project.hwanvis.hawnvisserver.infrastructure.claude.dto.ClaudeChatRequest;
import project.hwanvis.hawnvisserver.infrastructure.claude.dto.ClaudeChatResponse;
import project.hwanvis.hawnvisserver.infrastructure.claude.feign.ClaudeFeignClient;
import project.hwanvis.hawnvisserver.service.PromptService;

@Component
public class ClaudePromptService implements PromptService {
    private final ClaudeFeignClient claudeFeignClient;
    private final ClaudeProperties claudeProperties;
    ;

    public ClaudePromptService(
            ClaudeFeignClient claudeFeignClient, ClaudeProperties claudeProperties
    ) {
        this.claudeFeignClient = claudeFeignClient;
        this.claudeProperties = claudeProperties;
    }

    @Override
    public CreatePromptResponse createPrompt(CreatePromptRequest request) {
        ClaudeChatResponse response = claudeFeignClient.chat(
                request.apiKey(),
                claudeProperties.getApiVersion(),
                ClaudeChatRequest.of(
                        request,
                        claudeProperties.getModel(),
                        claudeProperties.getMaxTokens()
                )
        );

        return mapFrom(response);
    }

    private CreatePromptResponse mapFrom(ClaudeChatResponse response) {
        return new CreatePromptResponse(
                response.getContent(),
                response.role(),
                Vendor.CLAUDE.getName()
        );
    }

    @Override
    public boolean isSupport(String vendorName) {
        return Vendor.CLAUDE.isNameEqual(vendorName);
    }
}
