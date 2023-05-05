package com.tax.caluculation.application.controller;

import com.tax.caluculation.domain.resource.IncomeTaxForSeverancePayDTO;
import com.tax.caluculation.domain.resource.Tax;
import com.tax.caluculation.domain.service.CalcIncomeTaxForSeverancePay;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalcTax {
  private final CalcIncomeTaxForSeverancePay calcIncomeTaxForSeverancePay;

  @PostMapping("/calc-tax")
  public Tax incomeTax(@RequestBody IncomeTaxForSeverancePayDTO req){
    int incomeTax = calcIncomeTaxForSeverancePay.doCalculation(req);
    Tax tax = new Tax(incomeTax);
    return tax;
  }
}
