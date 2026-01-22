package com.spring.ai.project.AIProject.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

    //both beans are of same type, so we will name beans
//    and we can directly autowire any model chat client - and use Qualifier when using

    @Bean(name = "ollamaChatClient")
    public ChatClient ollamaChatModel(OllamaChatModel chatModel){

        return ChatClient.builder(chatModel).build();
    }

    @Bean(name = "googleGenAiChatClient")
    public ChatClient googleGenAiChatModel(GoogleGenAiChatModel chatModel){
        return ChatClient.builder(chatModel).build();
    }
}
