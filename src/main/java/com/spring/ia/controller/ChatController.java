package com.spring.ia.controller;

import com.spring.ia.dto.ChatRequest;
import com.spring.ia.dto.ChatResponse;
import com.spring.ia.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ChatResponse preguntar(
            @RequestBody ChatRequest request) {

        return ChatResponse.builder()
                .respuesta(
                        chatService.responder(
                                request.getPregunta()))
                .build();
    }
}
