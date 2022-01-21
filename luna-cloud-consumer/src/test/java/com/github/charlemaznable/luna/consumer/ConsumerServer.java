package com.github.charlemaznable.luna.consumer;

import com.github.charlemaznable.luna.commons.LunaApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@LunaApplication
@EnableEurekaServer
@EnableFeignClients
public class ConsumerServer {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServer.class, args);
    }
}
