package com.myretail.products.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.exception.MyRetailException;
import com.myretail.exception.PriceNotFoundException;
import com.myretail.exception.ProductNotFoundException;
import com.myretail.products.service.ProductService;
import com.myretail.products.views.Error;
import com.myretail.products.views.Item;
import com.myretail.products.views.Price;
import com.myretail.products.views.Product;
import com.myretail.products.views.ProductCompositeResponse;
import com.myretail.products.views.TargetProductResponse;
import com.target.products.service.TargetProductService;

@RestController
@RequestMapping(value="/restws/api/products")
public class ProductController{
	Logger logger = LoggerFactory.getLogger(ProductController.class);
			
	@Autowired
	private ProductService productService;
	
	@Autowired
	private TargetProductService targetProductService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product getProductPrice(@PathVariable("id") Integer id) {
		logger.debug("Entering into getProductPrice() in ProductController");
		Product product = new Product();
		product.setId(id);
		List<Error> errors = new ArrayList<>();
		
		// call product service to get the product price details
		try{
			Price price= productService.getProductPrice(id);
			if(null != price)
				product.setPrice(price);
		} catch (PriceNotFoundException e){
			logger.error("price not found || errorCode:"+e.getErrorCode()+" || description:"+e.getMessage());
			errors.add(prepareErrorJson(e.getMessage()));
		} catch (MyRetailException e){
			logger.error("Error getting price info || errorCode:"+e.getErrorCode()+" || description:"+e.getMessage());
			errors.add(prepareErrorJson(e.getMessage()));
		} catch (Exception e){
			logger.error("Error getting price info || errorCode:"+MyRetailException.GENERAL_EXCEPTION+" || description:"+e.getMessage());
			errors.add(prepareErrorJson(e.getMessage()));
		}
		
		// call external service to get the product name
		try{
			TargetProductResponse response = targetProductService.getProductDetails(id);
			if(null != response){
				ProductCompositeResponse productCompositeResponse = response.getProductCompositeResponse();
				
				// get product name
				if(null != productCompositeResponse && (null != productCompositeResponse.getItems() || productCompositeResponse.getItems().isEmpty())) {
					for(Item item : productCompositeResponse.getItems()){
						if(null != item){
							if(null != item.getErrors() && !item.getErrors().isEmpty()){
								for(Error error : item.getErrors()){
									errors.add(error);
								}
							} else {
								product.setName(item.getGeneralDescription());
								break;
							}
						}
					}
				}
			}
		} catch (ProductNotFoundException e){
			logger.error("product not found || errorCode:"+e.getErrorCode()+" || description:"+e.getMessage());
			errors.add(prepareErrorJson(e.getMessage()));
		} catch (MyRetailException e){
			logger.error("Error getting product info || errorCode:"+e.getErrorCode()+" || description:"+e.getMessage());
			errors.add(prepareErrorJson(e.getMessage()));
		} catch (Exception e){
			logger.error("Error getting product info || errorCode:"+MyRetailException.GENERAL_EXCEPTION+" || description:"+e.getMessage());
			errors.add(prepareErrorJson(e.getMessage()));
		}
		
		if(!errors.isEmpty())
			product.setErrors(errors);
		
		logger.debug("Exiting from getProductPrice() in ProductController");
		return product;
	}
	
	@RequestMapping(value="/target/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TargetProductResponse getTargetProduct(@PathVariable("id") Integer id) {
		logger.debug("Entering into getTargetProduct() in ProductController");
		// call external service to get the product name
		TargetProductResponse response = null;
		
		try{
			response = targetProductService.getProductDetails(id);
		} catch (ProductNotFoundException e){
			logger.error("product not found || errorCode:"+e.getErrorCode()+" || description:"+e.getMessage());
		} catch (MyRetailException e){
			logger.error("Error getting product info || errorCode:"+e.getErrorCode()+" || description:"+e.getMessage());
		} catch (Exception e){
			logger.error("Error getting product info || errorCode:"+MyRetailException.GENERAL_EXCEPTION+" || description:"+e.getMessage());
		}
		
		return response;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Product updateProductPrice(@RequestBody Product product) {
		if(null == product)
			return product;
		boolean status = false;
		try {
			status = productService.updateProductPrice(product);
		} catch (MyRetailException e) {
			logger.error("Error:"+e.getMessage());
		}
		
		product.setStatus(String.valueOf(status));
		return product;
	}
	
	private Error prepareErrorJson(String message){
		Error error = new Error();
		error.setMessage(message);
		return error;
	}
}
