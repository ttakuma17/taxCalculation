package com.tax.caluculation.domain.resource;

public class IncomeTaxForSeverancePayDTO {
  private int yearsOfService;
  private boolean isDisability;
  private boolean isOfficer;
  private int severancePay;

  public IncomeTaxForSeverancePayDTO(int yearsOfService, boolean isDisability, boolean isOfficer, int severancePay){
    this.yearsOfService = yearsOfService;
    this.isDisability = isDisability;
    this.isOfficer = isOfficer;
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
    return this.isOfficer;
  }

  public void setIsOfficer(boolean isOfficer){
    this.isOfficer = isOfficer;
  }

  public int getSeverancePay(){
    return this.severancePay;
  }

  public void setSeverancePay(int severancePay){
    this.severancePay = severancePay;
  }

}
