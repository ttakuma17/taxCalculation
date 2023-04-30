package com.tax.caluculation.domain.service;

import org.springframework.stereotype.Service;
import com.tax.caluculation.domain.resource.RetirementIncomeDeductionDTO;

@Service
public class CalcTax {


  public int calcRetirementIncomeDeduction(RetirementIncomeDeductionDTO input){
    return 800000;
  }

}
