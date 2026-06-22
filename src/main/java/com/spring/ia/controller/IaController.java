package com.spring.ia.controller;

import com.spring.ia.service.LlmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ia")
@RequiredArgsConstructor
public class IaController {

    private final LlmService llmService;

    @GetMapping("/ping")
    public String ping() {

        return llmService.consultar(
                "Responde únicamente OK");
    }
}