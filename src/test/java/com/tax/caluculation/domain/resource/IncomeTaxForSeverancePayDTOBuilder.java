package com.tax.caluculation.domain.resource;

public class IncomeTaxForSeverancePayDTOBuilder {
  private int yearsOfService;
  private boolean isDisability;
  private boolean isOfficer;
  private int severancePay;

  public IncomeTaxForSeverancePayDTOBuilder yearsOfService(int yearsOfService) {
    this.yearsOfService = yearsOfService;
    return this;
  }

  public IncomeTaxForSeverancePayDTOBuilder isDisability(boolean isDisability) {
    this.isDisability = isDisability;
    return this;
  }

  public IncomeTaxForSeverancePayDTOBuilder isOfficer(boolean isOfficer) {
    this.isOfficer = isOfficer;
    return this;
  }

  public IncomeTaxForSeverancePayDTOBuilder severancePay(int severancePay) {
    this.severancePay = severancePay;
    return this;
  }

  public IncomeTaxForSeverancePayDTO build() {
    return new IncomeTaxForSeverancePayDTO(yearsOfService, isDisability, isOfficer,severancePay);
  }
}
