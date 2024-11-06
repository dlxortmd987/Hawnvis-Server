package project.hwanvis.hawnvisserver.infrastructure.openai.dto;

import java.util.List;
import java.util.Objects;

public record OpenAiChatResponse(
        List<Choice> choices
) {
    private Choice getFisrtChoice() {
        if (choices == null || choices.isEmpty()) {
            return null;
        }

        return choices.getFirst();
    }

    public String getContent() {
        Choice fisrtChoice = getFisrtChoice();
        if (fisrtChoice == null) {
            return null;
        }

        return fisrtChoice.getContent();
    }

    public String getRole() {
        Choice fisrtChoice = getFisrtChoice();
        if (fisrtChoice == null) {
            return null;
        }

        return fisrtChoice.getRole();
    }

    public record Choice(
            OpenAiMessage message
    ) {

        public String getContent() {
            if (Objects.isNull(message)) {
                return null;
            }
            return message().content();
        }

        public String getRole() {
            if (Objects.isNull(message)) {
                return null;
            }
            return message().role();
        }
    }
}
