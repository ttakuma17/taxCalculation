package com.tax.caluculation.domain.resource;

public class TaxableRetirementIncomeDTO {
  private int years;
  private int retirementBenefit;
  private int retirementIncomeDeduction;
  private boolean isExecutive;

  public TaxableRetirementIncomeDTO(int years, int retirementBenefit, int retirementIncomeDeduction, boolean isExecutive){
    this.years = years;
    this.retirementBenefit = retirementBenefit;
    this.retirementIncomeDeduction = retirementIncomeDeduction;
    this.isExecutive = isExecutive;
  }

  public int getYears(){
    return this.years;
  }

  public void setYears(int years){
    this.years = years;
  }

  public int getRetirementBenefit(){
    return this.retirementBenefit;
  }

  public void setRetirementBenefit(int retirementBenefit){
    this.retirementBenefit = retirementBenefit;
  }

  public int getRetirementIncomeDeduction(){
    return this.retirementIncomeDeduction;
  }

  public void setRetirementIncomeDeduction(int retirementIncomeDeduction){
    this.retirementIncomeDeduction = retirementIncomeDeduction;
  }

  public boolean getIsExecutive(){
    return this.isExecutive;
  }

  public void setIsExecutive(boolean isExecutive){
    this.isExecutive = isExecutive;
  }
}
