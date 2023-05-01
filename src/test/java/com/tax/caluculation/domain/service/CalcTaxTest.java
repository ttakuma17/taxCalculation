package com.tax.caluculation.domain.service;

import com.tax.caluculation.domain.resource.RetirementIncomeDeductionDTO;
import com.tax.caluculation.domain.resource.RetirementIncomeDeductionDTOBuilder;
import java.util.stream.Stream;
import net.bytebuddy.asm.Advice.Argument;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(CalcTax.class)
class CalcTaxTest {

  @Autowired
  private CalcTax calcTax;

  @ParameterizedTest
  @MethodSource("provideArguments")
  public void testCalcRetirementIncomeDeduction(int years, boolean isDisability , int expected){

    RetirementIncomeDeductionDTO dto = new RetirementIncomeDeductionDTOBuilder()
        .years(years).isDisability(isDisability).build();

    int deduction = calcTax.calcRetirementIncomeDeduction(dto);
    assertThat(deduction).isEqualTo(expected);
  }

  /**
   * 勤続年数, 障害, 控除額
   * 勤続年数は1年、2年以上19年以下の場合、20年以上の場合で基準がわかれる
   * @return Parameterized Test
   */
  private static Stream<Arguments> provideArguments(){
    return Stream.of(
        Arguments.of(1, false, 800000),
        Arguments.of(2, false, 800000),
        Arguments.of(3, false, 1200000),
        Arguments.of(19, false, 7600000),
        Arguments.of(20, false, 8000000),
        Arguments.of(21, false, 8700000),
        Arguments.of(30, false, 15000000),
        Arguments.of(1, true, 1800000),
        Arguments.of(2, true, 1800000),
        Arguments.of(3, true, 2200000),
        Arguments.of(19, true, 8600000),
        Arguments.of(20, true, 9000000),
        Arguments.of(21, true, 9700000),
        Arguments.of(30, true, 16000000)
    );
  }
}
