package com.loanflow.service;

import org.springframework.stereotype.Service;

@Service 
public class HealthService {
    public String getStatus(){
        return "LoanFlow application is running!";
    }
}
