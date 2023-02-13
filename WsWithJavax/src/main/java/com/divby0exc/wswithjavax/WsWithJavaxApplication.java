package com.divby0exc.wswithjavax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class WsWithJavaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsWithJavaxApplication.class, args);
    }

}
