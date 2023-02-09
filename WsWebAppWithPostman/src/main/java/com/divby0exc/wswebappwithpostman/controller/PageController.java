package com.divby0exc.wswebappwithpostman.controller;

import com.divby0exc.wswebappwithpostman.model.UserDefinedEndpoint;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.messaging.Message;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/sub/{annons}")
public class PageController {

    private Session session;
    private static Set<UserDefinedEndpoint> endpoints = new CopyOnWriteArraySet<>();
    private static Map<String, String> annonser = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("annons") String annons) throws IOException {
    }
    @OnMessage
    public void onMessage(Session session, Message message) throws IOException {

    }
    @OnClose
    public void onClose(Session session) throws IOException {

    }
    @OnError
    public void onError(Session session, Throwable throwable) {

    }
}
