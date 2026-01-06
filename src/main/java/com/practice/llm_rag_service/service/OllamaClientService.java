package com.practice.llm_rag_service.service;

import com.practice.llm_rag_service.model.ChatMessage;
import com.practice.llm_rag_service.model.ChatRequest;
import com.practice.llm_rag_service.model.ChatResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OllamaClientService {

    private final RestClient restClient;
    private final String model;

    public OllamaClientService(
            @Value("${ollama.base-url}") String baseUrl,
            @Value("${ollama.model}") String model
    ) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
        this.model = model;
    }

    public ChatResponse chat(String userPrompt) {
        ChatRequest request = new ChatRequest(
                model,
                List.of(
                        new ChatMessage("system", "You are a helpful Java backend assistant."),
                        new ChatMessage("user", userPrompt)
                ),
                false
        );

        return restClient.post()
                .uri("/api/chat")
                .body(request)
                .retrieve()
                .body(ChatResponse.class);
    }
}
