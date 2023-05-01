package com.tax.caluculation.domain.resource;

/**
 * Test Data Builderとして定義
 *
 * DTOクラスの実装詳細をテストコードから隠蔽するために利用
 * テストコードは本番環境に影響を与えない、かつ、build時に除外される
 */
public class RetirementIncomeDeductionDTOBuilder {

  private int years;
  private boolean isDisability;

  public RetirementIncomeDeductionDTOBuilder years(int years) {
    this.years = years;
    return this;
  }

  public RetirementIncomeDeductionDTOBuilder isDisability(boolean isDisability) {
    this.isDisability = isDisability;
    return this;
  }

  public RetirementIncomeDeductionDTO build() {
    return new RetirementIncomeDeductionDTO(years, isDisability);
  }
}
