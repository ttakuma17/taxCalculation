package com.tax.caluculation.domain.service;

import com.tax.caluculation.domain.resource.TaxableRetirementIncomeDTO;
import org.springframework.stereotype.Service;

/**
 * 課税退職所得金額を計算するクラス
 *
 * 仕様
 * 課税退職所得金額 = (退職金 - 退職所得控除額) * 1 / 2
 *
 * 注
 * 役員など勤続年数が5年以下である方については次の通り
 * 退職金の額から退職所得控除を差し引いた残額が課税退職所得金額となる
 * 1/2の計算の適用はなし
 *
 * 注2
 * 役員等以外の勤続年数が5年以下である方は次の通り
 * 退職金の額から退職所得控除額を差し引いた額のうち300万円を超える部分については上記計算式
 * 1/2 の計算の適用はなし
 *
 * 注3
 * 課税退職所得金額に1000円未満の端数がある時はこれを切り捨てる
 */

@Service
public class CalcTaxableRetirementIncome {

  public int doCalculation(TaxableRetirementIncomeDTO input) {
    /**
     *  控除額が退職所得より大きければ 課税退職所得は0になる
     */
    if(isExcessDeduction(input))  return 0;

    /**
     * 役員か否かで退職所得金額の計算は異なる
     */
    if(input.getIsExecutive()) return getAdjustedAmount(getExecutiveAmount(input));
    else return getAdjustedAmount(getEmployeeAmount(input));
  }

  /**
   * 1000円以下の端数の切り捨てを行う関数
   * @param amount
   * @return 1000円以下切り捨て後のamount
   */
  private int getAdjustedAmount(int amount) {
    if (amount >= 1000) return amount / 1000 * 1000;
    else return amount;
  }

  private int getEmployeeAmount(TaxableRetirementIncomeDTO input) {
    int amount = input.getRetirementBenefit() - input.getRetirementIncomeDeduction();

    if(input.getYears() > 5) return amount / 2;
    else return calcEmployeeRetirementAmount(amount);

    }

  /**
   * 従業員の課税退職所得金額の計算関数
   * 勤続年数が5年以下の役員以外の社員に対して使用する
   * @param amount 退職金 - 控除額
   * @return 課税退職所得金額
   */
  private int calcEmployeeRetirementAmount(int amount) {
    if(amount >= 3000000) return amount - 3000000 + (3000000 / 2);
    else return amount / 2;
  }

  private int getExecutiveAmount(TaxableRetirementIncomeDTO input) {
    int amount = input.getRetirementBenefit() - input.getRetirementIncomeDeduction();

    if(input.getYears() <= 5) return amount;
    else return amount /2;
  }

  private boolean isExcessDeduction(TaxableRetirementIncomeDTO input) {
    return input.getRetirementBenefit() - input.getRetirementIncomeDeduction() <= 0;
  }
}
