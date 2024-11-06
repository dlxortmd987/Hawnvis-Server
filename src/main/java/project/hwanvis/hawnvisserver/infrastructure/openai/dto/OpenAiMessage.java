package project.hwanvis.hawnvisserver.infrastructure.openai.dto;

import project.hwanvis.hawnvisserver.controller.dto.CreatePromptRequest;

import java.util.List;

public record OpenAiMessage(
        String role,
        String content
) {
    public static List<OpenAiMessage> from(List<CreatePromptRequest.MessageRequest> messages) {
        return messages.stream()
                .map(it -> new OpenAiMessage(it.role(), it.content()))
                .toList();
    }
}
