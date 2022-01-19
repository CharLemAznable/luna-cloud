package com.github.charlemaznable.luna.examples.eureka.single;

import com.github.charlemaznable.luna.commons.LunaApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@LunaApplication
@EnableEurekaServer
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
