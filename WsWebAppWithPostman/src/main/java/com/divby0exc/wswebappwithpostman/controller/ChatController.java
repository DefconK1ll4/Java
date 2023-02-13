package com.divby0exc.wswebappwithpostman.controller;

import com.divby0exc.wswebappwithpostman.model.DTOChannel;
import com.divby0exc.wswebappwithpostman.model.Message;
import jakarta.websocket.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class ChatController {
    final Logger logger = LoggerFactory.getLogger(ChatController.class);

    /** /sub/channels/ ← en socket för den permanenta chatt-kanalen. Här skickas annonser som har skapats via POST förfrågan.**/
    @MessageMapping("/announcements")
    @SendTo("/sub")
    public String send(@Payload String msg, DTOChannel channel) throws IOException {
        System.out.println(msg);
        return msg;
    }
    /** /sub/chat/ ← en (eller flera) socket där du ansluter mot en
     * specifik kanal (via id-värde) och lyssnar på nya meddelanden
     * från kanalen samt kan skicka tillbaka svar via samma socket. **/
    @MessageMapping("/chat/{chat_id}")
    @SendTo("/sub/chat/{chat_id}")
    public Message sendToChat(Message message, jakarta.websocket.Session session) throws IOException {

        return null;
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
