package com.loanflow.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HealthServiceTest {

    @Test
    void shouldReturnApplicationStatus() {
        HealthService service = new HealthService();

        String result = service.getStatus();

        assertEquals(
            "LoanFlow application is running!",
            result
        );
    }
}