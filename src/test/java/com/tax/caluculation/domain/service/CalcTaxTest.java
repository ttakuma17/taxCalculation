package com.tax.caluculation.domain.service;

import com.tax.caluculation.domain.resource.RetirementIncomeDeductionDTO;
import com.tax.caluculation.domain.resource.RetirementIncomeDeductionDTOBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(CalcTax.class)
class CalcTaxTest {

  @Autowired
  private CalcTax calcTax;

  @Test
  public void testCalcRetirementIncomeDeduction(){

    RetirementIncomeDeductionDTO dto = new RetirementIncomeDeductionDTOBuilder()
        .years(2).isDisability(false).build();

    int deduction = calcTax.calcRetirementIncomeDeduction(dto);
    assertThat(deduction).isEqualTo(800000);
  }
}

/**
 * Todo 5.6.3〜続き
 * 2 .
 * パラメタライズテストで実装する
 */
