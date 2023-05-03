package com.tax.caluculation.domain.service;

import com.tax.caluculation.domain.resource.TaxationRetirementIncomeAmountDTO;
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
public class CalcTaxationRetirementIncomeAmount {

  public int calcTaxationRetirementIncomeAmount(TaxationRetirementIncomeAmountDTO input) {
    int amount = 0;

    // 控除額の方が大きい時課税金額は 0になる
    if(isExcessDeduction(input))  return amount;

    if(input.getIsExecutive()){

      if(input.getYears() <= 5){
        amount =
            (input.getRetirementBenefit() - input.getRetirementIncomeDeduction());
      } else {
        amount =
            (input.getRetirementBenefit() - input.getRetirementIncomeDeduction()) / 2;
      }

    } else {

      if(input.getYears() <= 5){
        if((input.getRetirementBenefit() - input.getRetirementIncomeDeduction()) >= 3000000){
          amount =  (input.getRetirementBenefit() - input.getRetirementIncomeDeduction() - 3000000) + (3000000 / 2);
        }else {
          amount =
              (input.getRetirementBenefit() - input.getRetirementIncomeDeduction()) / 2;
        }
      } else {
        amount =
            (input.getRetirementBenefit() - input.getRetirementIncomeDeduction()) / 2;
      }
    }

    if (amount >= 1000) {
      amount = amount / 1000 * 1000;
    }
    return amount;
  }

  private boolean isExcessDeduction(TaxationRetirementIncomeAmountDTO input) {
    return input.getRetirementBenefit() - input.getRetirementIncomeDeduction() <= 0;
  }
}
