package com.spring.ai.project.AIProject.Controller;

import com.spring.ai.project.AIProject.Service.ChatServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {

    public ChatServiceImpl chatService;
    public ChatController(ChatServiceImpl chatService){
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat( @RequestParam(value = "q", required = true) String q ){
        return ResponseEntity.ok(chatService.chat(q)) ;

//        return ResponseEntity.ok(chatService.chatTemplate()) ;

    }
}
