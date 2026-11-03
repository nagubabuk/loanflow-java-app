package com.loanflow.service;

import org.springframework.stereotype.Service;

@Service 
public class MessageService {
    public String getMessage(){
        return "Welcome to LoanFlow App";
    }
}
