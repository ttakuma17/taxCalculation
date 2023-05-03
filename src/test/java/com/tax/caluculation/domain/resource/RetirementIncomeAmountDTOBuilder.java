package com.tax.caluculation.domain.resource;

/**
 * Test Data Builderとして定義
 *
 * DTOクラスの実装詳細をテストコードから隠蔽するために利用
 * テストコードは本番環境に影響を与えない、かつ、build時に除外される
 */
public class RetirementIncomeAmountDTOBuilder {
  private int years;
  private int retirementBenefit;
  private int retirementIncomeDeduction;
  private boolean isExecutive;

  public RetirementIncomeAmountDTOBuilder years(int years) {
    this.years = years;
    return this;
  }

  public RetirementIncomeAmountDTOBuilder retirementBenefit(int retirementBenefit) {
    this.retirementBenefit = retirementBenefit;
    return this;
  }

  public RetirementIncomeAmountDTOBuilder retirementIncomeDeduction(int retirementIncomeDeduction) {
    this.retirementIncomeDeduction = retirementIncomeDeduction;
    return this;
  }

  public RetirementIncomeAmountDTOBuilder isExecutive(boolean isExecutive) {
    this.isExecutive = isExecutive;
    return this;
  }

  public TaxationRetirementIncomeAmountDTO build() {
    return new TaxationRetirementIncomeAmountDTO(years, retirementBenefit, retirementIncomeDeduction,isExecutive);
  }

}
