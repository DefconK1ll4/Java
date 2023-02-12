package com.divby0exc.wswebappwithpostman.controller;

import com.divby0exc.wswebappwithpostman.model.DTOChannel;
import com.divby0exc.wswebappwithpostman.model.Message;
import jakarta.websocket.OnOpen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Controller
public class ChatController {
    final Logger logger = LoggerFactory.getLogger(ChatController.class);

    /** /sub/channels/ ← en socket för den permanenta chatt-kanalen. Här skickas annonser som har skapats via POST förfrågan.**/
    @MessageMapping("/announcements")
    @SendTo("/sub/channels")
    public String send(DTOChannel channel) {
        return "New channel was registered with ID: " + channel.getId();
    }
    /** /sub/chat/ ← en (eller flera) socket där du ansluter mot en
     * specifik kanal (via id-värde) och lyssnar på nya meddelanden
     * från kanalen samt kan skicka tillbaka svar via samma socket. **/
    @MessageMapping("/chat/{chat_id}")
    @SendTo("/sub/chat/{chat_id}")
    public Message sendToChat(Message message, jakarta.websocket.Session session) throws IOException {
        session.getBasicRemote().sendText(message.getFrom() + "\n" + message.getContent());
        return message;
    }
    /**
    @OnOpen
    public void onOpen(Session session) throws IOException {
        session.getBasicRemote().sendText("onOpen");
    }

    @OnMessage
    public String echo(String message) {
        return message + " (from your server)";
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @OnClose
    public void onClose(Session session) {

    }
    **/
}
