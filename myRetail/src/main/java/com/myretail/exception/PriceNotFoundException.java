package com.myretail.exception;

public class PriceNotFoundException extends MyRetailException {
  private static final long serialVersionUID = 1L;
  private static final String PRICE_NOT_FOUND = "1001";
  
  public PriceNotFoundException() {
     super("1001");
  }
  
  public PriceNotFoundException(String message) {
     super("1001", message);
  }
}