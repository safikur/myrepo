package com.target.products.service;

import com.myretail.exception.MyRetailException;
import com.myretail.exception.ProductNotFoundException;
import com.myretail.products.views.TargetProductResponse;

public interface TargetProductService {

	public TargetProductResponse getProductDetails(Integer paramInteger) throws ProductNotFoundException, MyRetailException;
}
