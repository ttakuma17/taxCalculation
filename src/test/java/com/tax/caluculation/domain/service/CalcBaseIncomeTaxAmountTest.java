package com.tax.caluculation.domain.service;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(CalcBaseIncomeTaxAmount.class)
class CalcBaseIncomeTaxAmountTest {

  @Autowired CalcBaseIncomeTaxAmount calcBaseIncomeTaxAmount;

  @ParameterizedTest
  @CsvSource({
      "0,0",
      "1000,50",
      "1949000,97450",
      "1950000,97500",
      "3299000,232400",
      "3300000,232500",
      "6949000,962300",
      "6950000,962500",
      "8999000,1433770",
      "9000000,1434000",
      "17999000,4403670",
      "18000000,4404000",
      "39999000,13203600",
      "39999000,13203600",
      "40000000,13204000"
  })
  public void testCalcBaseIncomeTaxAmount(int taxationRetirementIncomeAmount, int expected){
    int amount = calcBaseIncomeTaxAmount.CalcBaseIncomeTaxAmount(taxationRetirementIncomeAmount);
    assertThat(amount).isEqualTo(expected);
  }
}
