package com.inditex.prueba.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Slf4j
public class HealthController {

    @GetMapping(path = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public String health() {
        log.info("health ok.");
        return "{\"Health\" : \"OK.\"}";
    }
}
