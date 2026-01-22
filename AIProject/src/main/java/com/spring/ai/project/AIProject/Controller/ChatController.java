package com.spring.ai.project.AIProject.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {

    private ChatClient ollamaChatClient;
    private ChatClient googleGenAiChatClient;

    //constructor injecting ChatClients , & Using Qualifiers -  which bean injection we want in which parameter variable
    public ChatController(@Qualifier("ollamaChatClient") ChatClient ollamaChatClient, @Qualifier("googleGenAiChatClient") ChatClient googleGenAiChatClient){
        this.ollamaChatClient = ollamaChatClient;
        this.googleGenAiChatClient = googleGenAiChatClient;
    }

//    private ChatClient chatClient; //we will not get Bean of this chat client auto from Spring, We need ChatClient.Builder, then We will get Bean

    //we have AutoWired it here - contructor injection don't need to write AutoWired
//    public ChatController(ChatClient.Builder builder){ //cuntructor to bring ChatClientBuilder bean
//        this.chatClient = builder.build();
//    }


    @GetMapping("/chat")
    public ResponseEntity<String> chat(
            @RequestParam(value = "q", required = true) String q
    ){
                // query sent, execute, Took result from it
        var resultResponse = this.googleGenAiChatClient
                .prompt(q)
                .call()
                .content();
        return ResponseEntity.ok(resultResponse) ;
    }
}
