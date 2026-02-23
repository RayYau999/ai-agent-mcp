package com.aiagent.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("ai-chat")
@RestController
public class AIChatController {

    private final ChatClient chatClient;

    public AIChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public String chat(@RequestBody String message) {
        return chatClient.prompt(message).call().content();
    }

}