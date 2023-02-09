package com.divby0exc.wswebappwithpostman.controller;

import com.divby0exc.wswebappwithpostman.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MsgController {
    @MessageMapping("/app")
    @SendTo("/container/msg")
    public Message send(Message message) {
        return message;
    }
}
