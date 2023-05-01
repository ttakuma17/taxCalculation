package com.tax.caluculation.domain.resource;

public class RetirementIncomeDeductionDTO {

  /**
   * yearsOfService 勤続年数
   * isDisability 障害者となったことに起因して退職したか
   */
  private int yearsOfService;
  private boolean isDisability;

  public RetirementIncomeDeductionDTO(int yearsOfService, boolean isDisability) {
    this.yearsOfService = yearsOfService;
    this.isDisability = isDisability;
  }

  public int getYearsOfService() {
    return this.yearsOfService;
  }

  public void setYearsOfService() {
    this.yearsOfService = yearsOfService;
  }

  public boolean getIsDisability() {
    return this.isDisability;
  }

  public void setIsDisability() {
    this.isDisability = isDisability;
  }
}
