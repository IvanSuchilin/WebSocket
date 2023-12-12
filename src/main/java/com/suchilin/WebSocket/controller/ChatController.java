package com.suchilin.WebSocket.controller;

import com.suchilin.WebSocket.models.ChatMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ChatController {
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    private final SimpMessagingTemplate template;

    @Autowired
    public ChatController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @MessageMapping("/send_message")
    public void messageReceiver(@Payload ChatMessage chatMessage) {
        logger.info("New message: " + chatMessage);
        template.convertAndSendToUser(chatMessage.getReceiver(), "/chat_out/receive_message", chatMessage);
    }
}
