package com.divby0exc.wswebappwithpostman.controller;

import com.divby0exc.wswebappwithpostman.encoding.MessageDecoder;
import com.divby0exc.wswebappwithpostman.encoding.MessageEncoder;
import com.divby0exc.wswebappwithpostman.model.Message;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/sub/{annons}",
decoders = MessageDecoder.class,
encoders = MessageEncoder.class)
public class PageController {

    private Session session;
    private int id;
    private static Set<PageController> endpoints = new CopyOnWriteArraySet<>();
    private static Map<String, String> annonser = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("annons") String annons) throws IOException, EncodeException {
        this.session = session;
        endpoints.add(this);
        annonser.put(session.getId(), annons);

        Message message = new Message();
        message.setFrom(session.getId());
        message.setContent("Connected");
        broadcast(message);
    }
    @OnMessage
    public void onMessage(Session session, Message message) throws IOException, EncodeException {
        message.setFrom(annonser.get(session.getId()));
        broadcast(message);
    }
    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        annonser.remove(this);
        Message message = new Message();
        message.setFrom(annonser.get(session.getId()));
        message.setContent("Disconnected");
        broadcast(message);
    }
    @OnError
    public void onError(Session session, Throwable throwable) {

    }
    private static void broadcast(Message message) throws  IOException, EncodeException {
        endpoints.forEach(customEndpoint -> {
            synchronized (customEndpoint) {
                try {
                    customEndpoint.session.getBasicRemote().sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
