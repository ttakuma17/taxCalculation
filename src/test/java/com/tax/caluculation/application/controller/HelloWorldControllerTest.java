package com.tax.caluculation.application.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
        .andExpect(content().string("{\"message\":\"Hello Json\"}"));
  }

  @Test
  public void testStatusCode() throws Exception{
    mockMvc.perform(post("/check-status-code"))
        .andExpect(status().isInternalServerError())
        .andExpect(content().string("{\"message\":\"Hello Status code!\"}"));
  }

  @Test
  public void testRequestBody() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.post("/check-body").contentType(MediaType.APPLICATION_JSON).content(
        "{\"message\":\"Hello Request Body!\"}"))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(content().string("{\"message\":\"Hello Request Body!\"}"));
  }
}
