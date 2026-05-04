package com.app.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    private final Counter getPingCounter;

    public TestController(MeterRegistry  meterRegistry) {
        this.getPingCounter = Counter.builder("api_ping_calls")
            .description("Namber of GET calls api : /api/va/ping")
            .tag("endpoint", "/api/va/ping")
            .tag("method", "get")
            .register(meterRegistry);
    }

    @GetMapping("/ping")
    public String ping() {
        log.info("Call ping endpoint");
        getPingCounter.increment();
        return "work - OK";
    }
}
