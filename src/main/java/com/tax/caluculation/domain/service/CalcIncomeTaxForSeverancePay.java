package com.tax.caluculation.domain.service;

import com.tax.caluculation.domain.resource.IncomeTaxForSeverancePayDTO;
import com.tax.caluculation.domain.resource.RetirementIncomeDeductionDTO;
import com.tax.caluculation.domain.resource.TaxableRetirementIncomeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

    RetirementIncomeDeductionDTO a = new RetirementIncomeDeductionDTO(dto.getYearsOfService(), dto.getIsDisability());
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
