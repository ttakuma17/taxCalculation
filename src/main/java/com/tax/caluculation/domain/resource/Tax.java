package com.tax.caluculation.domain.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tax {
  private final String TAX = "tax";

  @JsonProperty(TAX)
  private int taxAmount;

  public Tax(int taxAmount){
    this.taxAmount = taxAmount;
  }

  public int getTaxAmount() {
    return taxAmount;
  }
}
