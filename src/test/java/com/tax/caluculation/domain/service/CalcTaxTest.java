package com.tax.caluculation.domain.service;

import com.tax.caluculation.domain.service.CalcTax;
import com.tax.caluculation.domain.resource.RetirementIncomeDeductionDTO;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CalcTaxTest {

  @Test
  public void testCalcRetirementIncomeDeduction(){

    int deduction = calcRetirementIncomeDeduction(
        new RetirementIncomeDeductionDTO(2,false)
    );
    assertThat(deduction).isEqualTo(800000);
  }

  private int calcRetirementIncomeDeduction(RetirementIncomeDeductionDTO incomeDeductionDTO) {
    return 0;
  }
}
