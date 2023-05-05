package com.tax.caluculation.domain.service;

import com.tax.caluculation.domain.resource.IncomeTaxForSeverancePayDTO;
import com.tax.caluculation.domain.resource.RetirementIncomeDeductionDTO;
import com.tax.caluculation.domain.resource.TaxableRetirementIncomeDTO;
import com.tax.caluculation.domain.resource.ValidationErrorResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@Validated
public class CalcIncomeTaxForSeverancePay {
  @Autowired
  CalcRetirementIncomeDeduction calcRetirementIncomeDeduction;
  @Autowired
  CalcTaxableRetirementIncome calcTaxableRetirementIncome;
  @Autowired
  CalcIncomeTaxBase calcIncomeTaxBase;
  @Autowired
  CalcIncomeTaxWithHeld calcIncomeTaxWithHeld;

  public int doCalculation(IncomeTaxForSeverancePayDTO dto) {

    int retirementIncomeDeduction = calcRetirementIncomeDeduction.doCalculation(
        new RetirementIncomeDeductionDTO(dto.getYearsOfService(), dto.getIsDisability())
    );

    int taxableRetirementIncome = calcTaxableRetirementIncome.doCalculation(
        new TaxableRetirementIncomeDTO(
            dto.getYearsOfService(), dto.getSeverancePay(), retirementIncomeDeduction,dto.getIsOfficer()
        )
    );

    int incomeTaxBase = calcIncomeTaxBase.doCalculation(taxableRetirementIncome);

    return calcIncomeTaxWithHeld.doCalculation(incomeTaxBase);
  }
}
