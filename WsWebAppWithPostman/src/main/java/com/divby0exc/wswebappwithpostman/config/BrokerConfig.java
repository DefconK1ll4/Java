package com.divby0exc.wswebappwithpostman.config;

import com.divby0exc.wswebappwithpostman.model.UserDefinedEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class BrokerConfig implements WebSocketMessageBrokerConfigurer {

    UserDefinedEndpoint userDefinedEndpoint = new UserDefinedEndpoint();
    @Override
    public void configureMessageBroker(MessageBrokerRegistry path) {
        path.enableSimpleBroker("/sub");
        for(int i = 0; i < userDefinedEndpoint.getEndpoints().size(); i++) {
            userDefinedEndpoint.getEndpoints().get(i);
        }
        path.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws");
        registry.addEndpoint("/ws").withSockJS();
    }
}
