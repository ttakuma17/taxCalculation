package com.tax.caluculation.application.controller;

import org.springframework.beans.factory.annotation.Value;
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
  public String helloPost(){
    return "Hello POST";
  }

}
