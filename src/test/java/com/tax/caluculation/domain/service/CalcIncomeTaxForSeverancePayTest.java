package com.tax.caluculation.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.tax.caluculation.domain.resource.IncomeTaxForSeverancePayDTO;
import com.tax.caluculation.domain.resource.IncomeTaxForSeverancePayDTOBuilder;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalcIncomeTaxForSeverancePayTest {

  @Autowired
  CalcIncomeTaxForSeverancePay calcIncomeTaxForSeverancePay;

  @ParameterizedTest
  @MethodSource("provideArguments")
  public void testCalcIncomeTaxForSeverancePay(int yearsOfService, boolean isDisability, boolean isExecutive, int severancePay,int expected){
    IncomeTaxForSeverancePayDTO dto = new IncomeTaxForSeverancePayDTOBuilder()
        .yearsOfService(yearsOfService)
        .isDisability(isDisability)
        .isExecutive(isExecutive)
        .severancePay(severancePay)
        .build();

    int actual = calcIncomeTaxForSeverancePay.doCalculation(dto);
    assertThat(actual).isEqualTo(expected);

  }

  private static Stream<Arguments> provideArguments() {
    return Stream.of(
        Arguments.of(5,false,false, 8000000, 482422),
        Arguments.of(10,false,false, 8000000, 104652),
        Arguments.of(5,true,false, 8000000, 278222),
        Arguments.of(10,true,false, 8000000, 76575),
        Arguments.of(5,false,true, 8000000, 788722),
        Arguments.of(10,false,true, 8000000, 104652),
        Arguments.of(5,true,true, 8000000, 584522),
        Arguments.of(10,true,true, 8000000, 76575)
    ) ;
  }

}
