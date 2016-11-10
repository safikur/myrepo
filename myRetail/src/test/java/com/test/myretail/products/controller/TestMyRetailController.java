package com.test.myretail.products.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.myretail.products.controller.ProductController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-myretail-config.xml"})
public class TestMyRetailController {

	private MockMvc mockMvc;
	
	@Autowired
	private ProductController productController;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}
	
//	@Test
	public void getProduct() throws Exception {
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders
					.get("/myretail/restws/api/products/15117729"))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}
	
	@Test
	public void getTargetProduct() throws Exception {
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders
					.get("/myretail/restws/api/products/target/13860428"))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}
}
