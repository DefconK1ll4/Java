package com.divby0exc.wswebappwithpostman.model;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;

import java.util.ArrayList;
import java.util.List;

public class UserDefinedEndpoint {
    private final String startEndpoint = "/sub";
    private String customEndpoint;
    private String singleEndpoint;

    List<MessageBrokerRegistry> endpoints;

    public UserDefinedEndpoint() {
        this.endpoints = new ArrayList<>();
    }
    public void addEndpoint(MessageBrokerRegistry path) {
        endpoints.add(path);
    }
    public List<MessageBrokerRegistry> getEndpoints() {
        return endpoints;
    }

    public String getSingleEndpoint() {
        return singleEndpoint;
    }

    public void setSingleEndpoint(String singleEndpoint) {
        this.singleEndpoint = startEndpoint + "/" + singleEndpoint;
    }

    public String getStartEndpoint() {
        return startEndpoint;
    }

    public String getCustomEndpoint() {
        return customEndpoint;
    }

    public void setCustomEndpoint(String customEndpoint) {
        this.customEndpoint = customEndpoint;
    }
}
