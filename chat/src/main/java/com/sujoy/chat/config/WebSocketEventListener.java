package com.sujoy.chat.config;


import com.sujoy.chat.chat.ChatMessage;
import com.sujoy.chat.chat.MessageType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component

public class WebSocketEventListener {

    @Autowired
    private final SimpMessageSendingOperations messageTemplate;

    public WebSocketEventListener(SimpMessageSendingOperations messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){

        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");

        if(username != null){
            var chatMessage = new ChatMessage(username, MessageType.LEAVE);


            messageTemplate.convertAndSend("/topic/public", chatMessage);


        }

    }
}
