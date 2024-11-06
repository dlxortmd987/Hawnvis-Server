package project.hwanvis.hawnvisserver.controller.dto;

public record CreatePromptResponse(
        String content,
        String role,
        String model
) {
}
