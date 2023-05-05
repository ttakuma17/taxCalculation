package com.tax.caluculation.application.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.tax.caluculation.domain.service.CalcIncomeTaxForSeverancePay;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CalcTax.class)
class CalcTaxTest {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  private CalcIncomeTaxForSeverancePay calcIncomeTaxForSeverancePay;

  @Test
  void testCalcIncomeTaxForSeverancePay() throws Exception{
    when(calcIncomeTaxForSeverancePay.doCalculation(any())).thenReturn(25524);

    mockMvc.perform(MockMvcRequestBuilders.post("/calc-tax")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {
                  "yearsOfService": 5,
                  "isDisability": false,
                  "isOfficer": false,
                  "severancePay": 3000000
                }
                """)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().json("{\"tax\":25524}"));
  }
}
