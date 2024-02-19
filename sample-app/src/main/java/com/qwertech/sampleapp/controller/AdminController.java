package com.qwertech.sampleapp.controller;

import com.qwertech.sampleapp.health.ManualHealthIndicator;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.actuate.health.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ManualHealthIndicator manualHealthIndicator;

    @GetMapping("/manualHealthIndicator")
    public @NotNull Status getManualHealthIndicator() {
        return manualHealthIndicator.getStatus();
    }

    @PostMapping("/manualHealthIndicator")
    public void setManualHealthIndicator(@RequestBody @NotNull Status status) {
        manualHealthIndicator.setStatus(status);
    }

}
