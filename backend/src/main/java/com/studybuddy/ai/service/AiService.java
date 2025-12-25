package com.studybuddy.ai.service;

import org.springframework.stereotype.Service;

@Service
public class AiService {

    public String getReply(String message) {
        // dummy AI (we replace later with real OpenAI)
        return "AI Reply: " + message;
    }
}

