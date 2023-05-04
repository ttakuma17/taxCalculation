package com.tax.caluculation.domain.resource;

public class IncomeTaxForSeverancePayDTO {
  private int yearsOfService;
  private boolean isDisability;
  private boolean isExecutive;
  private int severancePay;

  public IncomeTaxForSeverancePayDTO(int yearsOfService, boolean isDisability, boolean isExecutive, int severancePay){
    this.yearsOfService = yearsOfService;
    this.isDisability = isDisability;
    this.isExecutive = isExecutive;
    this.severancePay = severancePay;
  }

  public int getYearsOfService(){
    return this.yearsOfService;
  }

  public void setYearsOfService(int yearsOfService){
    this.yearsOfService = yearsOfService;
  }


  public boolean getIsDisability(){
    return this.isDisability;
  }

  public void setIsDisability(boolean isDisability){
    this.isDisability = isDisability;
  }

  public boolean getIsOfficer(){
    return this.isExecutive;
  }

  public void setIsOfficer(boolean isOfficer){
    this.isExecutive = isOfficer;
  }

  public int getSeverancePay(){
    return this.severancePay;
  }

  public void setSeverancePay(int severancePay){
    this.severancePay = severancePay;
  }

}
