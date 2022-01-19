package com.github.charlemaznable.luna.producer;

import com.github.charlemaznable.luna.commons.LunaApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@LunaApplication
@EnableDiscoveryClient
@EnableEurekaServer
@EnableFeignClients
public class ProducerServer {

    public static void main(String[] args) {
        SpringApplication.run(ProducerServer.class, args);
    }
}
