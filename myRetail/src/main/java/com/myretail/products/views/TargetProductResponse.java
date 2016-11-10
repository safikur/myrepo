package com.myretail.products.views;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TargetProductResponse {
	@JsonProperty("product_composite_response")
	private ProductCompositeResponse productCompositeResponse;

	public ProductCompositeResponse getProductCompositeResponse() {
		return productCompositeResponse;
	}

	public void setProductCompositeResponse(ProductCompositeResponse productCompositeResponse) {
		this.productCompositeResponse = productCompositeResponse;
	}
}
