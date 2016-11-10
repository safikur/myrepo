package com.myretail.products.service;

import com.myretail.exception.MyRetailException;
import com.myretail.exception.PriceNotFoundException;
import com.myretail.products.views.Price;
import com.myretail.products.views.Product;

public abstract interface ProductService{
  public abstract Price getProductPrice(Integer paramInteger) throws PriceNotFoundException, MyRetailException;
  
  public abstract boolean updateProductPrice(Product paramProduct) throws MyRetailException;
}