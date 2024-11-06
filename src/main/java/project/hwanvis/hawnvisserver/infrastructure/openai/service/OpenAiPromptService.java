package project.hwanvis.hawnvisserver.infrastructure.openai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import project.hwanvis.hawnvisserver.controller.dto.CreatePromptRequest;
import project.hwanvis.hawnvisserver.controller.dto.CreatePromptResponse;
import project.hwanvis.hawnvisserver.domain.Vendor;
import project.hwanvis.hawnvisserver.infrastructure.openai.dto.OpenAiChatRequest;
import project.hwanvis.hawnvisserver.infrastructure.openai.dto.OpenAiChatResponse;
import project.hwanvis.hawnvisserver.infrastructure.openai.feign.OpenAiFeignClient;
import project.hwanvis.hawnvisserver.service.PromptService;

@Primary
@Component
public class OpenAiPromptService implements PromptService {
    private final OpenAiFeignClient openAiFeignClient;
    private final String defaultModel;

    public OpenAiPromptService(
            OpenAiFeignClient openAiFeignClient,
            @Value("${feign.openai.model}") String defaultModel
    ) {
        this.openAiFeignClient = openAiFeignClient;
        this.defaultModel = defaultModel;
    }

    @Override
    public CreatePromptResponse createPrompt(CreatePromptRequest request) {
        OpenAiChatResponse response = openAiFeignClient.chat(
                request.getPrefixAddedApiKey(),
                OpenAiChatRequest.of(request, defaultModel)
        );

        return mapFrom(response);
    }

    private CreatePromptResponse mapFrom(OpenAiChatResponse response) {
        return new CreatePromptResponse(
                response.getContent(),
                response.getRole(),
                Vendor.GPT.getName()
        );
    }

    @Override
    public boolean isSupport(String vendorName) {
        return Vendor.GPT.isNameEqual(vendorName);
    }
}
