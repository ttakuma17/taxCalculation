package com.tax.caluculation.domain.resource;

public class BaseIncomeTaxAmountDTO {
  private int taxationRetirementIncomeAmount;
  private double taxRate;
  private int deduction;

  public BaseIncomeTaxAmountDTO(int taxationRetirementIncomeAmount, double taxRate, int deduction) {
    this.taxationRetirementIncomeAmount = taxationRetirementIncomeAmount;
    this.taxRate = taxRate;
    this.deduction = deduction;
  }

  public int getTaxationRetirementIncomeAmount(){
    return this.taxationRetirementIncomeAmount;
  }

  public void setTaxationRetirementIncomeAmount(int taxationRetirementIncomeAmount){
    this.taxationRetirementIncomeAmount = taxationRetirementIncomeAmount;
  }

  public double getTaxRate(){
    return this.taxRate;
  }

  public void setTaxRate(double taxRate){
    this.taxRate = taxRate;
  }

  public int getDeduction(){
    return this.deduction;
  }

  public void setDeduction(int deduction){
    this.deduction = deduction;
  }
}
