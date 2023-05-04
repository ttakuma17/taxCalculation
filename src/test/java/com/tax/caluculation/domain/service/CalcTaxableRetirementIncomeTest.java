package com.tax.caluculation.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.tax.caluculation.domain.resource.TaxableRetirementIncomeDTO;
import com.tax.caluculation.domain.resource.RetirementIncomeAmountDTOBuilder;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(CalcTaxableRetirementIncome.class)
class CalcTaxableRetirementIncomeTest {

  @Autowired
  private CalcTaxableRetirementIncome calcTaxableRetirementIncome;

  @ParameterizedTest
  @MethodSource("provideArguments")
  public void testCalcTaxationRetirementIncomeAmount(int years, int retirementBenefit, int retirementIncomeDeduction ,boolean isExecutive,int expected){
    TaxableRetirementIncomeDTO dto = new RetirementIncomeAmountDTOBuilder()
        .years(years)
        .retirementBenefit(retirementBenefit)
        .retirementIncomeDeduction(retirementIncomeDeduction)
        .isExecutive(isExecutive)
        .build();

    int amount = calcTaxableRetirementIncome.doCalculation(dto);
    assertThat(amount).isEqualTo(expected);
  }

  private static Stream<Arguments> provideArguments() {
    return Stream.of(
        Arguments.of(6,3000000,2400000,false,300000),
        Arguments.of(6,3000000,2400000,true,300000),
        Arguments.of(6,3001999,2400000,false,300000),
        Arguments.of(6,3001999,2400000,true,300000),
        Arguments.of(6,3002000,2400000,false,301000),
        Arguments.of(6,3002000,2400000,true,301000),
        Arguments.of(6,1000000,2400000,false,0),
        Arguments.of(6,1000000,2400000,true,0),
        Arguments.of(5,3000000,2000000,true,1000000),
        Arguments.of(5,3000999,2000000,true,1000000),
        Arguments.of(5,3001000,2000000,true,1001000),
        Arguments.of(5,1000000,2000000,true,0),
        Arguments.of(5,3000000,2000000,false,500000),
        Arguments.of(5,5000000,2000000,false,1500000),
        Arguments.of(5,3001999,2000000,false,500000),
        Arguments.of(5,3002000,2000000,false,501000),
        Arguments.of(5,1000000,2000000,false,0),
        Arguments.of(5,6000000,2000000,false,2500000),
        Arguments.of(5,6001999,2000000,false,2501000),
        Arguments.of(5,6002000,2000000,false,2502000)
    );
  }

}
