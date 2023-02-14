package com.divby0exc.wswebappwithpostman.handler;

import com.divby0exc.wswebappwithpostman.model.DTOChannel;
import com.divby0exc.wswebappwithpostman.service.ChannelServiceImpl;
import jakarta.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ServerEndpoint("/sub/chat/{channelId}/{username}")
public class DynamicEndpoint extends TextWebSocketHandler implements CustomEndpoint {
    final Logger logger = LoggerFactory.getLogger(DynamicEndpoint.class);
    private Map<WebSocketSession, DTOChannel> config;
    ChannelServiceImpl cs;
    DTOChannel newChannel;
    private List<DTOChannel> userDetails = new ArrayList<>();
    public DynamicEndpoint() {
        this.cs = new ChannelServiceImpl();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session, @PathVariable("channelId") String title, @PathVariable("username") String username) throws Exception {
        this.config = new HashMap<>();
        newChannel = new DTOChannel(title, username);

        userDetails.addAll(cs.getAll());
        System.out.println("Size of new acquired channels arr: " + userDetails.size());

        for (DTOChannel c : userDetails) {
            if (c.getTitle().equals(newChannel.getTitle())) {
                System.out.println("Title from channels in loop: " + c.getTitle());
                logger.atInfo().log("Found channel in db");
                config.put(session, newChannel);

            } else {
                logger.atInfo().log("No channel registered with title: ");
                broadcast("No channel registered with such title");
            }
        }

        logger.atInfo().log("From param: " + config.get(session).getTitle() + config.get(session).getUsername());
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String request = "From: " + config.get(session).getUsername() + ": " + message.getPayload();
        logger.atInfo().log("Server received: {}", request);

        broadcast(request);
    }

    @Override
    public void sendPeriodicMessages() throws IOException {

    }

    public void broadcast(String payload) throws IOException {
        for (Map.Entry<WebSocketSession, DTOChannel> s : config.entrySet()) {
            if(s.getKey().isOpen()) {
                s.getKey().sendMessage(new TextMessage(payload));
            }
        }
    }
}
