package project.hwanvis.hawnvisserver.service;

import project.hwanvis.hawnvisserver.controller.dto.CreatePromptRequest;
import project.hwanvis.hawnvisserver.controller.dto.CreatePromptResponse;

public interface PromptService {
    CreatePromptResponse createPrompt(CreatePromptRequest request);

    boolean isSupport(String vendorName);
}