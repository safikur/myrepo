package com.myretail.exception;

public class ProductNotFoundException extends MyRetailException {
  private static final long serialVersionUID = 1L;
  private static final String PRODUCT_NOT_FOUND = "1001";
  
  public ProductNotFoundException() {
     super("1001");
  }
  
  public ProductNotFoundException(String message) {
     super("1001", message);
  }
}