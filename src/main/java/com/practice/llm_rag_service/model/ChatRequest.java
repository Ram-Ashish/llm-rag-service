package com.practice.llm_rag_service.model;

import java.util.List;

public record ChatRequest(
        String model,
        List<ChatMessage> messages,
        boolean stream
) {}
