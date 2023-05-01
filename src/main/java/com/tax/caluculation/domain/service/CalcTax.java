package com.tax.caluculation.domain.service;

import org.springframework.stereotype.Service;
import com.tax.caluculation.domain.resource.RetirementIncomeDeductionDTO;

@Service
public class CalcTax {

  public int calcRetirementIncomeDeduction(RetirementIncomeDeductionDTO input){
    int result = 0;

    if(input.getYearsOfService() == 1){
      result = 800000;
    }else if (input.getYearsOfService() <= 19){
      result = 400000 * input.getYearsOfService();
    }else {
      result = 8000000 + 700000 * (input.getYearsOfService() - 20);
    }

    if(input.getIsDisability()){
      result += 1000000;
    }
    return result;
  }
}
