package project.hwanvis.hawnvisserver.infrastructure.claude.dto;

import project.hwanvis.hawnvisserver.controller.dto.CreatePromptRequest;

import java.util.List;

public record ClaudeChatRequest(
        String model,
        Integer maxTokens,
        List<ClaudeMessage> messages
) {
    public static ClaudeChatRequest of(CreatePromptRequest request, String model, Integer maxTokens) {
        return new ClaudeChatRequest(
                model,
                maxTokens,
                ClaudeMessage.from(request.messageRequests())
        );
    }

    public record ClaudeMessage(
            String role,
            String content
    ) {
        public static List<ClaudeMessage> from(List<CreatePromptRequest.MessageRequest> messages) {
            return messages.stream()
                    .map(it -> new ClaudeMessage(it.role(), it.content()))
                    .toList();
        }
    }
}
