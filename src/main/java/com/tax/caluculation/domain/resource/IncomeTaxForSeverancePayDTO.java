package com.tax.caluculation.domain.resource;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class IncomeTaxForSeverancePayDTO {
  @NotNull(message = "勤続年数は必須です1〜100の間の数値を指定してください")
  @Min(value = 1, message ="勤続年数は1年以上100年以下のみ指定可能です")
  @Max(value = 100, message ="勤続年数は1年以上100年以下のみ指定可能です")
  private int yearsOfService;
  @NotNull(message = "障害による退職かどうか必須項目です。")
  @Pattern(regexp = "^(true|false)$", message = "isDisability は true か falseを指定してください")
  private boolean isDisability;
  @NotNull(message = "役員等かどうか必須項目です。")
  @Pattern(regexp = "^(true|false)$", message = "isOfficer は true か falseを指定してください")
  private boolean isExecutive;
  @NotNull(message = "退職金は必須項目です。")
  @Min(value = 1, message = "退職金の金額は1円以上1,000,000,000円以下のみ指定可能です")
  @Max(value = 1_000_000_000 , message = "退職金の金額は1円以上1,000,000,000円以下のみ指定可能です")
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
