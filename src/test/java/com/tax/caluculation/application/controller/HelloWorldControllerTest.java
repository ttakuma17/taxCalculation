package com.tax.caluculation.application.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testHelloWorld() throws Exception{
    mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello World"));
  }

  @Test
  public void testHelloPost() throws Exception{
    mockMvc.perform(post("/check-post"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello POST"));
  }
}
