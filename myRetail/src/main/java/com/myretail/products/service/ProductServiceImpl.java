package com.myretail.products.service;

import com.myretail.exception.MyRetailException;
import com.myretail.exception.PriceNotFoundException;
import com.myretail.products.beans.ProductPricing;
import com.myretail.products.price.bo.PriceBO;
import com.myretail.products.views.Price;
import com.myretail.products.views.Product;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ProductService")
public class ProductServiceImpl implements ProductService {
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private PriceBO priceBO;

	public Price getProductPrice(Integer productId) throws PriceNotFoundException, MyRetailException {
		logger.debug("Entering into getProductPrice() in ProductServiceImpl");

		ProductPricing productPricing = priceBO.getProductPrice(productId);

		Price price = new Price();
		price.setCurrencyCode(productPricing.getCurrencyCode());
		price.setValue(productPricing.getProductPrice());

		logger.debug("Exiting from getProductPrice() in ProductServiceImpl");
		return price;
	}

	public boolean updateProductPrice(Product product) throws MyRetailException {
		logger.debug("Entering into updateProductPrice() in ProductServiceImpl");
		if (null == product) {
			return false;
		}
		
		ProductPricing productPricing = new ProductPricing();
		productPricing.setProductId(product.getId());
		Price price = product.getPrice();
		
		if (null == price) {
			return false;
		}
		
		productPricing.setCurrencyCode(price.getCurrencyCode());
		productPricing.setProductPrice(price.getValue());
		productPricing.setUpdateDttm(new Date());
		productPricing.setUpdateUser("SYSTEM");

		priceBO.updateProductPrice(productPricing);
		
		logger.info("price updated successfully for product:" + product.getId());
		logger.debug("Exiting from updateProductPrice() in ProductServiceImpl");
		return true;
	}
}