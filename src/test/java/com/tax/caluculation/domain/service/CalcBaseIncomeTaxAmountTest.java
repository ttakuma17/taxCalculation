package com.tax.caluculation.domain.service;
import static org.assertj.core.api.Assertions.assertThat;

import com.tax.caluculation.domain.resource.BaseIncomeTaxAmountDTO;
import com.tax.caluculation.domain.resource.BaseIncomeTaxAmountDTOBuilder;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(CalcBaseIncomeTaxAmount.class)
class CalcBaseIncomeTaxAmountTest {

  @Autowired CalcBaseIncomeTaxAmount calcBaseIncomeTaxAmount;

  @ParameterizedTest
  @MethodSource("provideArguments")
  public void testCalcBaseIncomeTaxAmount(int taxationRetirementIncomeAmount, int expected){
    int amount = calcBaseIncomeTaxAmount.CalcBaseIncomeTaxAmount(taxationRetirementIncomeAmount);
    assertThat(amount).isEqualTo(expected);
  }

  private static Stream<Arguments> provideArguments() {
    return Stream.of(
        Arguments.of(0,0),
        Arguments.of(1000,50),
        Arguments.of(1949000,97450),
        Arguments.of(1950000,97500),
        Arguments.of(3299000,232400),
        Arguments.of(3300000,232500),
        Arguments.of(6949000,962300),
        Arguments.of(6950000,962500),
        Arguments.of(8999000,1433770),
        Arguments.of(9000000,1434000),
        Arguments.of(17999000,4403670),
        Arguments.of(18000000,4404000),
        Arguments.of(39999000,13203600),
        Arguments.of(40000000,13204000)
    );
  }
}
