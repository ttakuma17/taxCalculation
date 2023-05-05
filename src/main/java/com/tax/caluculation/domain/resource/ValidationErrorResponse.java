package com.tax.caluculation.domain.resource;

import java.util.List;
import lombok.Data;

@Data
public class ValidationErrorResponse {
  private String message;
  private List<String> errors;

  public ValidationErrorResponse(String message, List<String> errors) {
    this.message = message;
    this.errors = errors;
  }
}
