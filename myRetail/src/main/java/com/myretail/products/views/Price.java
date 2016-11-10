package com.myretail.products.views;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {
	@JsonProperty("value")
	private Double value;
	
	@JsonProperty("currency_code")
	private String currencyCode;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
