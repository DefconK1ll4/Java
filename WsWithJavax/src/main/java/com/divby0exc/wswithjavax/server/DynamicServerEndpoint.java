package com.divby0exc.wswithjavax.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/sub/chat/{channelId}")
public class DynamicServerEndpoint {
    final Logger logger = LoggerFactory.getLogger(DynamicServerEndpoint.class);
    private Session session;
    private static Map<String, String> users = new HashMap<>();
    private static Set<DynamicServerEndpoint> chatRooms = new CopyOnWriteArraySet<>();

}
