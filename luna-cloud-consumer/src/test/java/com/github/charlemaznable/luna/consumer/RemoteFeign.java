package com.github.charlemaznable.luna.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("test.consumer")
public interface RemoteFeign {

    @GetMapping("/produce")
    String produce(@RequestParam("name") String name);
}
