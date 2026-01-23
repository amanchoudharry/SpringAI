package com.spring.ai.project.AIProject.Service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatClient ollamaChatClient;
    private final ChatClient googleGenAiChatClient;

    public ChatServiceImpl(@Qualifier("ollamaChatClient") ChatClient ollamaChatClient, @Qualifier("googleGenAiChatClient") ChatClient googleGenAiChatClient){
        this.ollamaChatClient = ollamaChatClient;
        this.googleGenAiChatClient = googleGenAiChatClient;
    }

    @Override
    public String chat(String query){
        Prompt prompt1 = new Prompt(query, OllamaChatOptions.builder()
                .temperature(0.3)
                .build());

        return ollamaChatClient
                .prompt(prompt1)
                .call()
                .content();
    }

    @Override
    public String chatTemplate(){
        //1st Step Templating
        PromptTemplate strTemplate = PromptTemplate.builder().template(
                "What is {techName}? Tell me an example of {exampleName}").build();
        //2nd Step: render message
        String renderMsg = strTemplate.render(
                Map.of(
                        "techName","Spring",
                        "exampleName","Spring Exception"
                )
        );

        //creating Prompt
        Prompt prompt = new Prompt(renderMsg);

        //passing prompt we made to Gemini (here) ChatClient
        var response = googleGenAiChatClient
                .prompt(prompt)
                .call()
                .content();
        return response;
    }
}
