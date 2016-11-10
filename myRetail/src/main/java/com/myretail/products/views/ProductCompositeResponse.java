package com.myretail.products.views;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCompositeResponse {
	@JsonProperty("request_attributes")
	List<RequestAttribute> requestAttributes;
	
	@JsonProperty("items")
	List<Item> items;

	public List<RequestAttribute> getRequestAttributes() {
		return requestAttributes;
	}

	public void setRequestAttributes(List<RequestAttribute> requestAttributes) {
		this.requestAttributes = requestAttributes;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
