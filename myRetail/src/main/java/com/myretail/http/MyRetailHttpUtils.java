package com.myretail.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class MyRetailHttpUtils {
	protected static final Logger logger = LoggerFactory.getLogger(MyRetailHttpUtils.class);
	
	@Value("${http.connection.timeout}")
	private static int httpConnectionTimeout;
	
	@Value("${http.socket.timeout}")
	private static int httpSocketTimeout;
	
	public static CloseableHttpClient getHttpClient() {
		CloseableHttpClient closeableHttpClient;
		RequestConfig.Builder requestBuilder = RequestConfig
													.custom()
													.setSocketTimeout(httpSocketTimeout)
													.setConnectTimeout(httpConnectionTimeout);
		closeableHttpClient = HttpClients
								.custom()
								.setDefaultRequestConfig(requestBuilder.build())
								.build();
		
		return closeableHttpClient;
	}
}
