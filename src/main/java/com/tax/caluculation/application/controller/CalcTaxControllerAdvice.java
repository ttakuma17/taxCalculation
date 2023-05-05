package com.tax.caluculation.application.controller;

import com.tax.caluculation.domain.resource.ValidationErrorResponse;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CalcTaxControllerAdvice {

  private static final String TIMESTAMP = "timestamp";
  private static final String STATUS = "status";
  private static final String ERROR = "error";
  private static final String MESSAGE = "message";
  private static final String PATH = "path";
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss Z");

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ValidationErrorResponse handleValidationExceptions(MethodArgumentNotValidException e) {
    List<String> errors = e.getBindingResult().getAllErrors().stream()
        .map(ObjectError::getDefaultMessage).collect(Collectors.toList());
    return new ValidationErrorResponse("バリデーションエラー", errors);
  }
}
