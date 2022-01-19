package com.github.charlemaznable.luna.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;

@Slf4j
@RestController
public class ConsumerController {

    private RemoteFeign remoteFeign;

    @Autowired
    public ConsumerController(@Nonnull RemoteFeign remoteFeign) {
        this.remoteFeign = remoteFeign;
    }

    @GetMapping("/consume")
    public String consume(@RequestParam String name) {
        try {
            return remoteFeign.produce("dear " + name);
        } catch (Exception e) {
            log.debug("remote feign error: {}", e.getMessage());
            return e.getMessage();
        }
    }
}
