package com.tax.caluculation.domain.resource;

public class BaseIncomeTaxAmountDTOBuilder {
  private int taxationRetirementIncomeAmount;
  private double taxRate;
  private int deduction;

  public BaseIncomeTaxAmountDTOBuilder taxationRetirementIncomeAmount(int taxationRetirementIncomeAmount){
    this.taxationRetirementIncomeAmount = taxationRetirementIncomeAmount;
    return this;
  }

  public BaseIncomeTaxAmountDTOBuilder taxRate(double taxRate){
    this.taxRate = taxRate;
    return this;
  }

  public BaseIncomeTaxAmountDTOBuilder deduction(int deduction){
    this.deduction = deduction;
    return this;
  }

  public BaseIncomeTaxAmountDTO build() {
    return new BaseIncomeTaxAmountDTO(taxationRetirementIncomeAmount, taxRate, deduction);
  }
}
