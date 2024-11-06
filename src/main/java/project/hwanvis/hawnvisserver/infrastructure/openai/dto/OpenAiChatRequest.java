package project.hwanvis.hawnvisserver.infrastructure.openai.dto;

import project.hwanvis.hawnvisserver.controller.dto.CreatePromptRequest;

import java.util.List;

public record OpenAiChatRequest(
        List<OpenAiMessage> messages,
        String model
) {
    public static OpenAiChatRequest of(CreatePromptRequest request, String model) {
        return new OpenAiChatRequest(
                OpenAiMessage.from(request.messageRequests()),
                model
        );
    }
}
