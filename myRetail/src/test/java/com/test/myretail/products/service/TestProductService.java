package com.test.myretail.products.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myretail.products.service.ProductService;
import com.myretail.products.views.Price;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-myretail-config.xml"})
public class TestProductService {

	@Autowired
	private ProductService productService;
	
	@Test
	public void getProductPrice() throws Exception {
		Price price = productService.getProductPrice(15117729);
		System.out.println("currency:"+price.getCurrencyCode());
		System.out.println("price:"+price.getValue());
	}
	
//	@Test
	public void getTargetProduct() throws Exception {
//		System.out.println(result.getResponse().getContentAsString());
	}
}
