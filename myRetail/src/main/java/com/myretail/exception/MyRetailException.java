package com.myretail.exception;

public class MyRetailException extends Exception {
  private static final long serialVersionUID = 1L;
  public static final String GENERAL_EXCEPTION = "1000";
  private String errorCode;
  
  public MyRetailException() {}
  
  public MyRetailException(Throwable cause) {
	  super(cause);
  }
  
  public MyRetailException(String message) {
     super(message);
  }
  
  public MyRetailException(String message, Throwable cause) {
     super(message, cause);
  }
  
  public MyRetailException(String errorCode, String message) {
     super(message);
     this.errorCode = errorCode;
  }
  
  public String getErrorCode() {
     return this.errorCode;
  }
  
  public void setErrorCode(String errorCode) {
     this.errorCode = errorCode;
  }
}