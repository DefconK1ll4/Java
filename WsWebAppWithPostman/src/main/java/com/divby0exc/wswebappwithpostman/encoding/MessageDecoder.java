package com.divby0exc.wswebappwithpostman.encoding;

//import com.divby0exc.wswebappwithpostman.controller.APIController;
import com.divby0exc.wswebappwithpostman.model.Message;
import com.google.gson.Gson;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;
import jakarta.websocket.EndpointConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MessageDecoder implements Decoder.Text<Message> {
    private static Gson gson = new Gson();

    @Override
    public Message decode(String s) throws DecodeException {
        return gson.fromJson(s, Message.class);
    }
    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
    }

    @Override
    public void destroy() {
    }
}
