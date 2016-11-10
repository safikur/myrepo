package com.myretail.products.price.bo;

import com.myretail.exception.MyRetailException;
import com.myretail.exception.PriceNotFoundException;
import com.myretail.products.beans.ProductPricing;

public interface PriceBO {
	public ProductPricing getProductPrice(Integer paramInteger) throws PriceNotFoundException, MyRetailException;

	public abstract void updateProductPrice(ProductPricing paramProductPricing) throws MyRetailException;
}