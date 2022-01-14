package com.github.charlemaznable.luna.examples.eureka.single;

import com.github.charlemaznable.core.spring.ComplexBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(nameGenerator = ComplexBeanNameGenerator.class)
@EnableEurekaServer
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
