package com.divby0exc.wswebappwithpostman.config;

import com.divby0exc.wswebappwithpostman.handler.DynamicEndpoint;
import com.divby0exc.wswebappwithpostman.handler.ServerWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class BrokerConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(), "/sub/channels");
        registry.addHandler(customSocketHandler(), "/sub/chat/{channelId}/{username}");
    }

    @Bean
    public WebSocketHandler webSocketHandler() {
        return new ServerWebSocketHandler();
    }
    @Bean
    public WebSocketHandler customSocketHandler() {
        return new DynamicEndpoint();
    }
}
