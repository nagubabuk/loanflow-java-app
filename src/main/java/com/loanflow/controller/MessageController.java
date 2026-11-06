package com.loanflow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanflow.service.MessageService;

@RestController 
public class MessageController {
    private final MessageService messageService;
    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/api/message")
    public String getMessage(){
        return messageService.getMessage();
    }
}
