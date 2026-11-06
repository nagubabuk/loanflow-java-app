package com.loanflow.controller;

import com.loanflow.service.HealthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HealthController {
    private final HealthService healthService;
    public HealthController(HealthService healthService){
        this.healthService = healthService;
    }

    @GetMapping("/api/health")
    public String getHealth(){
        return healthService.getStatus();
    }
}
