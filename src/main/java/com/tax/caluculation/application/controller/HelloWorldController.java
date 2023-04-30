package com.tax.caluculation.application.controller;

import com.tax.caluculation.domain.resource.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping("/")
  public String helloWorld(){
    return "Hello World";
  }

  @PostMapping("/check-post")
  public ResponseEntity<Message> helloPost(){
    Message message = new Message("Hello Json");
    return ResponseEntity.ok().body(message);
  }
}
