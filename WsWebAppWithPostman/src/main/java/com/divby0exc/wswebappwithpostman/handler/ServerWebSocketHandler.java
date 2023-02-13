package com.divby0exc.wswebappwithpostman.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ServerWebSocketHandler extends TextWebSocketHandler {
    final Logger logger = LoggerFactory.getLogger(ServerWebSocketHandler.class);
    private List<WebSocketSession> userDetails = new ArrayList<>();

    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        userDetails.add(session);
        String request = message.getPayload();
        logger.atInfo().log("Server recieved: {}", request);

        String response = String.format("response from servr to '%s'", HtmlUtils.htmlEscape(request));
        logger.atInfo().log("Server sends: {}", response);
        session.sendMessage(new TextMessage(response));
    }

    @Scheduled(fixedRate = 10000)
    void sendPeriodicMessages() throws IOException {
        for (WebSocketSession session : userDetails) {
            if(session.isOpen()) {
                String broadcast = "server periodic message " + LocalTime.now();
                logger.atInfo().log("Server sendsa: {}", broadcast);
                session.sendMessage(new TextMessage(broadcast));
            }
        }
    }
}
