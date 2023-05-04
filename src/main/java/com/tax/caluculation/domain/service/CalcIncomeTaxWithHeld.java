package com.tax.caluculation.domain.service;

import org.springframework.stereotype.Service;

/**
 * 所得税の源泉徴収税額 を計算するクラス
 *
 * 所得税の源泉徴収額 = 基準所得税額 * 102.1%
 *
 * 求めた税額に1円未満の端数があるときは切り捨てる
 */
@Service
public class CalcIncomeTaxWithHeld {

  public int doCalculation(int amount) {
    double result = amount * 1.021;
    return getAdjustedTaxAmount(result);
  }

  private int getAdjustedTaxAmount(double amount) {
    if (amount >= 1000) return (int) (amount / 10 * 10);
    else return (int) amount;
  }
}
