package com.divby0exc.wswithjavax.server;

import com.divby0exc.wswithjavax.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Supplier;

@ServerEndpoint("/sub/channels")
public class PermServerEndpoint {
    final Logger logger = LoggerFactory.getLogger(PermServerEndpoint.class);

    private Session session;
    private static Map<String, String> users = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @RequestBody String username) throws EncodeException, IOException {
        this.session = session;
        users.put(session.getId(), username);

        Message msg = new Message();
        msg.setFrom(username);
        msg.setContent("Connected");
        broadcast(msg, session);
    }
    @OnMessage
    public void onMessage(Session session, Message msg) throws IOException, EncodeException {
        msg.setFrom(users.get(session.getId()));
        broadcast(msg, session);
    }
    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        Message msg = new Message();
        msg.setFrom(users.get(session.getId()));
        msg.setContent("Disconnected");
        broadcast(msg, session);
    }
    @OnError
    public void onError(Session session, Throwable t) {
        logger.atDebug().setMessage(session.getId()).addArgument(t).log();
    }

    private static void broadcast(Message msg, Session session) throws IOException, EncodeException {
        session.getBasicRemote().sendObject(msg);
    }
}
