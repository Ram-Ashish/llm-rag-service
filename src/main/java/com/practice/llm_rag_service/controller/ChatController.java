package com.practice.llm_rag_service.controller;

import com.practice.llm_rag_service.service.OllamaClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final OllamaClientService ollamaClientService;

    @Autowired
    public ChatController(OllamaClientService ollamaClientService) {
        this.ollamaClientService = ollamaClientService;
    }

    @PostMapping
    public String chat(@RequestBody String prompt) {
        return ollamaClientService.chat(prompt)
                .message()
                .content();
    }
}
