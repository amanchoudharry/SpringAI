package com.spring.ai.project.AIProject;

import com.spring.ai.project.AIProject.Service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ChatService chatService;

	@Test
	void testChatTemplate(){
		System.out.println("Chat template");

		System.out.println(this.chatService.chatTemplate());
	}
}
