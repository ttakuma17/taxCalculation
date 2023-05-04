package com.tax.caluculation.domain.service;

import org.springframework.stereotype.Service;

/**
 * 基準所得税額を計算するクラス
 *
 * 仕様
 * 基準所得税額 = 課税所得金額 * 税率 - 控除額 で算出される
 *
 */
@Service
public class CalcIncomeTaxBase {
  /**
   *
   * @param amount 課税退職所得金額
   * @return 基準所得税額
   */
  public int CalcBaseIncomeTaxAmount(int amount) {
    return (int) (amount * getTaxRate(amount) - getDeduction(amount));
  }

  /**
   * 対象の税率算出
   * @param amount 課税退職所得金額
   * @return 税率
   */
  private double getTaxRate(int amount){
    if(amount <= 1949000 ) return 0.05;
    else if (amount <= 3299000) return 0.1;
    else if (amount <= 6949000) return 0.2;
    else if (amount <= 8999000) return 0.23;
    else if (amount <= 17999000) return 0.33;
    else if (amount <= 39999000) return 0.4;
    else return 0.45;
  }

  /**
   * 控除額を返す関数
   * @param amount 課税退職所得金額
   * @return 控除額
   */
  private int getDeduction(int amount){
    if(amount <= 1949000 ) return 0;
    else if (amount <= 3299000) return 97500;
    else if (amount <= 6949000) return 427500;
    else if (amount <= 8999000) return 636000;
    else if (amount <= 17999000) return 1536000;
    else if (amount <= 39999000) return 2796000;
    else return 4796000;
  }
}
