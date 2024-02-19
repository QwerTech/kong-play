package com.qwertech.sampleapp.health;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class ManualHealthIndicator implements HealthIndicator {

    @Setter
    @Getter
    @NotNull
    private Status status = Status.UP;

    @Override
    public Health health() {
        return Health.status(status).build();
    }
}
