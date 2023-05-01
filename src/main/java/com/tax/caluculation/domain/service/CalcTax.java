package com.tax.caluculation.domain.service;

import org.springframework.stereotype.Service;
import com.tax.caluculation.domain.resource.RetirementIncomeDeductionDTO;

@Service
public class CalcTax {

  public int calcRetirementIncomeDeduction(RetirementIncomeDeductionDTO retirementIncomeDeductionInput){
    int deduction = getDeduction(retirementIncomeDeductionInput);
    deduction = addDeductionForDisability(retirementIncomeDeductionInput, deduction);
    return deduction;
  }

  private  int addDeductionForDisability(RetirementIncomeDeductionDTO retirementIncomeDeductionInput,
      int deduction) {
    if(retirementIncomeDeductionInput.getIsDisability()){
      deduction += 1000000;
    }
    return deduction;
  }

  private int getDeduction(RetirementIncomeDeductionDTO retirementIncomeDeductionInput) {
    int deduction;
    if(retirementIncomeDeductionInput.getYearsOfService() == 1){
      deduction = 800000;
    }else if (retirementIncomeDeductionInput.getYearsOfService() <= 19){
      deduction = 400000 * retirementIncomeDeductionInput.getYearsOfService();
    }else {
      deduction = 8000000 + 700000 * (retirementIncomeDeductionInput.getYearsOfService() - 20);
    }
    return deduction;
  }
}
