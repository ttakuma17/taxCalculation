package com.tax.caluculation.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(CalcIncomeTaxWithHeld.class)
class CalcIncomeTaxWithHeldTest {
  @Autowired
  CalcIncomeTaxWithHeld calcIncomeTaxWithHeld;

  @ParameterizedTest
  @CsvSource({
      "0 ,0",
      "50 ,51",
      "120 ,122",
      "1000 ,1021"
  })
  public void testCalcIncomeTaxWithholdingTaxAmount(int amount , int expected){
    int actual = calcIncomeTaxWithHeld.calcIncomeTaxWithholdingTaxAmount(amount);
    assertThat(actual).isEqualTo(expected);
  }
}
