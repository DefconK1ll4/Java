package com.divby0exc.wswebappwithpostman.handler;

import jakarta.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ServerEndpoint("/sub/channels")
public class ServerWebSocketHandler extends TextWebSocketHandler {
    final Logger logger = LoggerFactory.getLogger(ServerWebSocketHandler.class);
    private static List<WebSocketSession> userDetails = new ArrayList<>();
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        userDetails.add(session);
    }

    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String messageFromUser = message.getPayload();
        String fromUser = session.getId();
        logger.atInfo().log("Server received: {}", messageFromUser);
        logger.atInfo().log("Server received: {}", fromUser);

        broadcast(messageFromUser);
        broadcast(fromUser);
    }
    public static void broadcast(String payload) throws IOException {
        for (WebSocketSession sessions : userDetails) {
            if(sessions.isOpen()) {
                sessions.sendMessage(new TextMessage(payload));
            }
        }
    }
}
