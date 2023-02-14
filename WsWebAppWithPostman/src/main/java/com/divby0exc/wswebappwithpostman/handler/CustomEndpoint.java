package com.divby0exc.wswebappwithpostman.handler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

public interface CustomEndpoint extends WebSocketHandler {
    void afterConnectionEstablished(WebSocketSession session, @RequestParam("channelId") String title, @RequestParam("username") String username) throws Exception;

    void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception;

    @Scheduled(fixedRate = 10000)
    void sendPeriodicMessages() throws IOException;
}
