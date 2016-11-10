package com.myretail.products.price.bo;

import com.myretail.cassandra.accessor.ProductPriceAccessor;
import com.myretail.exception.MyRetailException;
import com.myretail.exception.PriceNotFoundException;
import com.myretail.products.beans.ProductPricing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("PriceBO")
public class PriceBOImpl implements PriceBO {
	Logger logger = LoggerFactory.getLogger(PriceBOImpl.class);
	
	@Autowired
	private ProductPriceAccessor productPriceAccessor;

	public ProductPricing getProductPrice(Integer productId) throws PriceNotFoundException, MyRetailException {
		logger.debug("Entering into getProductPrice() in PriceBOImpl");
		ProductPricing pricing;
		
		try {
			pricing = productPriceAccessor.getPriceByproductId(productId);
		} catch (Exception e) {
			throw new MyRetailException(e);
		}
		
		if (null == pricing) {
			throw new PriceNotFoundException("Price info not found for product:" + productId);
		}
		logger.debug("Exiting from getProductPrice() in PriceBOImpl");
		return pricing;
	}

	public void updateProductPrice(ProductPricing pricing) throws MyRetailException {
		logger.debug("Entering into updateProductPrice() in PriceBOImpl");
		try {
			productPriceAccessor
				.updatePrice(
						pricing.getProductId(), 
						pricing.getProductPrice(),
						pricing.getUpdateDttm(), 
						pricing.getUpdateUser());
		} catch (Exception e) {
			logger.error("Error while updating price details || productId:" + pricing.getProductId());
			throw new MyRetailException(e);
		}
	}
}