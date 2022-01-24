package com.github.charlemaznable.luna.consumer;

import com.github.charlemaznable.luna.consumer.RemoteFeign.FallbackFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "test.consumer", fallback = FallbackFeign.class)
public interface RemoteFeign {

    @GetMapping("/produce")
    String produce(@RequestParam("name") String name);

    @Component
    class FallbackFeign implements RemoteFeign {

        @Override
        public String produce(String name) {
            return "produce fallback";
        }
    }
}
