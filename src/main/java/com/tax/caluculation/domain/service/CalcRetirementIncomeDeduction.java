package com.tax.caluculation.domain.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.tax.caluculation.domain.resource.RetirementIncomeDeductionDTO;

/**
 * 退職所得控除額 を計算するクラス
 */
@Service
@Component
public class CalcRetirementIncomeDeduction {

  public int doCalculation(RetirementIncomeDeductionDTO retirementIncomeDeductionInput){
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
