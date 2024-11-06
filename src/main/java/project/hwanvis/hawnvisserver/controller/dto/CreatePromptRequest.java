package project.hwanvis.hawnvisserver.controller.dto;

import java.util.List;

public record CreatePromptRequest(
        String apiKey,
        List<MessageRequest> messageRequests,
        String vendor
) {
    public String getPrefixAddedApiKey() {
        return "Bearer %s".formatted(apiKey);
    }

    public record MessageRequest(
            String role,
            String content
    ) {
    }
}
