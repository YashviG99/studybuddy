package com.studybuddy.ai.controller;

import com.studybuddy.ai.dto.AiRequest;
import com.studybuddy.ai.dto.AiResponse;
import com.studybuddy.ai.service.AiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/chat")
    public AiResponse chat(@RequestBody AiRequest request) {
        String reply = aiService.getReply(request.getMessage());
        return new AiResponse(reply);
    }
}
