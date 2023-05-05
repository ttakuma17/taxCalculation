package com.tax.caluculation.application.controller;

import com.tax.caluculation.domain.resource.IncomeTaxForSeverancePayDTO;
import com.tax.caluculation.domain.resource.Message;
import com.tax.caluculation.domain.service.CalcIncomeTaxForSeverancePay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcTax {

  @PostMapping("/calc-tax")
  public ResponseEntity<Message> incomeTax(@RequestBody IncomeTaxForSeverancePayDTO req){
  }

}
