package org.demo.web.controller;

import org.demo.core.service.HealthService;
import org.demo.web.model.response.LivenessSuccessResponse;
import org.demo.web.model.response.ReadinessSuccessResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Slf4j
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/liveness")
    @ResponseStatus(HttpStatus.OK)
    public LivenessSuccessResponse checLiveness() {

        log.info("HealthController check liveness ");

        LivenessSuccessResponse livenessSuccessResponse = new LivenessSuccessResponse();
        livenessSuccessResponse.setAlive(healthService.checkLiveness());

        log.info("HealthController check liveness response <<<< with healthSuccessResponse={}", livenessSuccessResponse);

        return livenessSuccessResponse;
    }

    @GetMapping("/readiness")
    @ResponseStatus(HttpStatus.OK)
    public ReadinessSuccessResponse checkReadiness() {

        log.info("HealthController check readiness ");

        ReadinessSuccessResponse readinessSuccessResponse = new ReadinessSuccessResponse();
        readinessSuccessResponse.setReady(healthService.checkReadiness());

        log.info("HealthController check readiness response <<<< with readinessSuccessResponse={}", readinessSuccessResponse);

        return readinessSuccessResponse;
    }
}
