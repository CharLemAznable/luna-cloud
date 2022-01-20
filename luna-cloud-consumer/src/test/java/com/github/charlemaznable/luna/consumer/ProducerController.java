package com.github.charlemaznable.luna.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @GetMapping("/produce")
    public String produce(@RequestParam String name) {
        return "hello " + name + "，this is a empty world.";
    }
}
