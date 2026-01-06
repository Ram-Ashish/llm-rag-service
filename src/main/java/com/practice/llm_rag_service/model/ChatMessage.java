package com.practice.llm_rag_service.model;

public record ChatMessage(
        String role,
        String content
) {}
