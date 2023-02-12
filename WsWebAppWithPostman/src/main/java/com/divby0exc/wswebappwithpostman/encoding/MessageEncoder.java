package com.divby0exc.wswebappwithpostman.encoding;

import com.divby0exc.wswebappwithpostman.controller.APIController;
import com.divby0exc.wswebappwithpostman.model.Message;
import com.google.gson.Gson;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageEncoder implements Encoder.Text<Message> {
    private static Gson gson = new Gson();
    @Override
    public String encode(Message message) throws EncodeException {
        return gson.toJson(message);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
    }

    @Override
    public void destroy() {
    }
}
