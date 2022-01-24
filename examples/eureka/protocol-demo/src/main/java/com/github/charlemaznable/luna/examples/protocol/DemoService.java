package com.github.charlemaznable.luna.examples.protocol;

import com.github.charlemaznable.luna.examples.protocol.DemoService.FallbackLocal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo.service", fallback = FallbackLocal.class)
public interface DemoService {

    @GetMapping("/index")
    String index(@RequestParam("param") String param);

    final class FallbackLocal implements DemoService {

        @Override
        public String index(String param) {
            return "service fallback";
        }
    }
}
