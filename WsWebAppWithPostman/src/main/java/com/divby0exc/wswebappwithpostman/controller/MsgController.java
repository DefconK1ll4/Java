package com.divby0exc.wswebappwithpostman.controller;

import com.divby0exc.wswebappwithpostman.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MsgController {
    final Logger logger = LoggerFactory.getLogger(MsgController.class);
    @MessageMapping("/app")
    @SendTo("/container/msg")
    public Message send(Message message) {
        return message;
    }
}
