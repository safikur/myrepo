package com.target.products.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.exception.MyRetailException;
import com.myretail.exception.ProductNotFoundException;
import com.myretail.http.MyRetailHttpUtils;
import com.myretail.products.views.TargetProductResponse;

@Component("TargetProductService")
public class TargetProductServiceImpl implements TargetProductService {
	Logger logger = LoggerFactory.getLogger(TargetProductServiceImpl.class);
	
	@Value("${target.product.url1}")
	private String productUrl1;
	
	@Value("${target.product.url2}")
	private String productUrl2;
	
	@Override
	public TargetProductResponse getProductDetails(Integer productId) throws ProductNotFoundException, MyRetailException{
		logger.debug("Entering into getProductDetails() in TargetProductServiceImpl");
		TargetProductResponse targetProductResponse = null;
		HttpGet httpGet = new HttpGet(productUrl1+productId+productUrl2);
		
		try(CloseableHttpClient httpClient = MyRetailHttpUtils.getHttpClient();
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
			InputStreamReader inputStreamReader = new InputStreamReader(httpResponse.getEntity().getContent());
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader)){

			StringBuilder responseString = new StringBuilder();
			String currentLine;
			while((currentLine = bufferedReader.readLine()) != null)
				responseString.append(currentLine);
			
			targetProductResponse = jsonToObject(responseString.toString());
			
		} catch(IOException e){
			logger.error("Error:"+e.getMessage());
			throw new MyRetailException(e.getMessage());
		}
		
		logger.debug("Exiting from getProductDetails() in TargetProductServiceImpl");
		return targetProductResponse;
	}
	
	private TargetProductResponse jsonToObject(String json){
		TargetProductResponse targetProductResponse = null;
		try{
			ObjectMapper mapper = new ObjectMapper();
			targetProductResponse = mapper.readValue(json, TargetProductResponse.class);
		} catch (Exception e){
			logger.error("Error:"+e.getMessage());
		}
		
		return targetProductResponse;
	}
}
