package com.spring.ia.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.message.Message;

import java.util.List;

@Getter
@Setter
@Builder
public class OpenAiRequest {

    private String model;

    private List<ChatMessage> messages;
}
