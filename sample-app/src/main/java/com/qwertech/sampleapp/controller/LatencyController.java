package com.qwertech.sampleapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/latency")
@RequiredArgsConstructor
public class LatencyController {

    @GetMapping("/sleep/{millis}")
    public void sleep(@PathVariable("millis") long millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}
