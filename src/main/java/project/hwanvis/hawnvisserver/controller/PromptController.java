package project.hwanvis.hawnvisserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hwanvis.hawnvisserver.controller.dto.CreatePromptRequest;
import project.hwanvis.hawnvisserver.controller.dto.CreatePromptResponse;
import project.hwanvis.hawnvisserver.service.PromptService;

import java.util.List;

@RestController
@RequestMapping("/api/hwanvis")
public class PromptController {

    private final List<PromptService> promptServices;

    public PromptController(List<PromptService> promptServices) {
        this.promptServices = promptServices;
    }

    @PostMapping
    public CreatePromptResponse createPrompt(CreatePromptRequest request) {
        PromptService promptService = findPromptServiceByVendor(request);
        return promptService.createPrompt(request);
    }

    private PromptService findPromptServiceByVendor(CreatePromptRequest request) {
        for (PromptService promptService : promptServices) {
            if (promptService.isSupport(request.vendor())) {
                return promptService;
            }
        }
        throw new IllegalArgumentException("Unknown Vendor");
    }
}
