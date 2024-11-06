package project.hwanvis.hawnvisserver.infrastructure.claude.dto;

import java.util.List;

public record ClaudeChatResponse(
        List<ContentResponse> content,
        String role
) {
    public record ContentResponse(
            String text
    ) {
    }

    public String getContent() {
        if (content == null || content.isEmpty()) {
            return null;
        }

        return content.getFirst().text();
    }
}
