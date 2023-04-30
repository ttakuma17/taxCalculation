package com.tax.caluculation.domain.service;

import com.tax.caluculation.domain.service.CalcTax;
import com.tax.caluculation.domain.resource.RetirementIncomeDeductionDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(CalcTax.class)
class CalcTaxTest {

  @Autowired
  private CalcTax calcTax;

  @Test
  public void testCalcRetirementIncomeDeduction(){

    int deduction = calcTax.calcRetirementIncomeDeduction(
        new RetirementIncomeDeductionDTO(2,false)
    );
    assertThat(deduction).isEqualTo(800000);
  }
}
