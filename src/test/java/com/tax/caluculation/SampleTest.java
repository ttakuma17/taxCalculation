package com.tax.caluculation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SampleTest {

  @Test
  @DisplayName("Junit5の設定確認用のテスト")
  public void testSample(){
    assertEquals(2, 1 + 1);
  }
}
