package com.demo.websocket.controllers;

import com.demo.websocket.dtos.GreetingResponseDto;
import com.demo.websocket.dtos.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GreetingResponseDto greeting(HelloMessage message) throws Exception{
        Thread.sleep(1000);
        return new GreetingResponseDto("Hello, " + message.getName() + "!");
    }
}
