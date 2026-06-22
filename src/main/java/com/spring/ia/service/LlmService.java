package com.spring.ia.service;

import com.spring.ia.dto.ChatMessage;
import com.spring.ia.dto.OpenAiRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LlmService {

    private final RestClient restClient;

    @Value("${lmstudio.model}")
    private String model;

    public String consultar(String prompt) {

        OpenAiRequest request =
                OpenAiRequest.builder()
                        .model(model)
                        .messages(
                                List.of(
                                        ChatMessage.builder()
                                                .role("user")
                                                .content(prompt)
                                                .build()
                                )
                        )
                        .build();

        return restClient.post()
                .uri("/v1/chat/completions")
                .body(request)
                .retrieve()
                .body(String.class);
    }
}