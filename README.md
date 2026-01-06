# llm-rag-service

## Overview

`llm-rag-service` is a **Spring Boot–based backend service** that provides **local Large Language Model (LLM) capabilities** with a clear evolution path toward **Retrieval Augmented Generation (RAG)**.

The service is designed to:

- Run **fully locally** (offline-friendly)
- Integrate with **open-source LLMs** via Ollama
- Start with **plain conversational chat**
- Gradually evolve into a **production-grade RAG system**

This project is ideal for developers who want to understand and build **LLM-backed systems using Java and Spring Boot**, without relying on cloud-based AI APIs initially.

---

## Key Goals

- ✅ Local-first LLM execution (no vendor lock-in)
- ✅ Clean, extensible Spring Boot architecture
- ✅ Chat-first approach before RAG
- ✅ Plug-and-play LLM provider design (future-ready)
- ✅ Suitable for enterprise-grade microservices

---

## Technology Stack

| Layer         | Technology      |
| ------------- | --------------- |
| Language      | Java 21         |
| Framework     | Spring Boot 3.x |
| LLM Runtime   | Ollama          |
| Default Model | Mistral         |
| API Style     | REST (JSON)     |
| Build Tool    | Maven           |

---

## Current Capabilities (Phase 1: Chat)

### 1. Local LLM Chat

- Chat with an LLM running **entirely on your machine**
- No internet required after model download
- Deterministic and configurable responses

### 2. REST-based Chat API

- Simple REST endpoint to send prompts
- Clean request/response abstraction
- Easy to test via Postman or curl

### 3. Model Abstraction

- Model name configurable via `application.yml`
- No hard dependency on a single model

---

## Planned Capabilities (Roadmap)

### Phase 2: Conversation Enhancements

- In-memory conversation history
- Multi-turn chat support
- Session-based context handling

### Phase 3: Streaming Responses

- Token-level streaming from LLM
- Improved UX for frontend clients

### Phase 4: RAG (Retrieval Augmented Generation)

- Document ingestion (PDF, TXT, Markdown)
- Embedding generation using local models
- Vector storage integration
- Context-aware responses using retrieved documents

### Phase 5: Multi-LLM Support

- Strategy + Factory pattern for LLM providers
- Ollama (local)
- OpenAI / Azure OpenAI (optional)

---

## High-Level Architecture

```
Client (Postman / UI)
        │
        ▼
Spring Boot REST Controller
        │
        ▼
Chat / Query Service Layer
        │
        ▼
LLM Client Abstraction
        │
        ▼
Local LLM (Ollama)
```

Future RAG extension:

```
User Query
   │
   ├─► Vector Search (Context Retrieval)
   │
   └─► LLM Prompt Augmentation
           │
           ▼
       Final Answer
```

---

## Configuration

### application.yml

```yaml
spring:
  application:
    name: llm-rag-service

server:
  port: 8080

ollama:
  base-url: http://localhost:11434
  model: mistral
```

---

## API Documentation

### Chat Endpoint

**POST** `/api/chat`

#### Request Body

```
Explain Spring Boot auto-configuration
```

#### Response

```
Spring Boot auto-configuration automatically configures beans based on the classpath...
```

---

## Project Structure

```
llm-rag-service
├── controller
│   └── ChatController.java
├── service
│   └── OllamaClientService.java
├── model
│   ├── ChatMessage.java
│   ├── ChatRequest.java
│   └── ChatResponse.java
├── config
│   └── (future configurations)
└── LlmRagServiceApplication.java
```

---

## Why Local LLM?

- Data privacy
- No API cost
- Offline usage
- Full control over models
- Ideal for experimentation and learning

---

## Future Use Cases

- Developer assistant
- Internal knowledge base
- Code explanation tool
- Interview preparation assistant
- Enterprise document Q&A

---

## Development Philosophy

- Clean architecture
- Explicit abstractions
- No premature optimization
- Incremental feature growth

---

## Getting Started

1. Install Ollama
2. Pull a model (`mistral` recommended)
3. Start Ollama service
4. Run Spring Boot application
5. Test chat endpoint via Postman

---

## License

This project is intended for **learning, experimentation, and internal use**. You are free to extend and adapt it as needed.

---

## Next Steps

- Add conversation memory
- Enable streaming responses
- Introduce vector embeddings
- Build full RAG pipeline

---

**llm-rag-service** is built to grow from a simple chat service into a full-fledged **LLM-powered knowledge system**.

