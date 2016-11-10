package com.myretail.cassandra.accessor;

import java.util.Date;

import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.Query;
import com.myretail.products.beans.ProductPricing;
import com.myretail.products.constants.Constants;

@Accessor
public abstract interface ProductPriceAccessor{
  @Query("SELECT product_id, product_price, currency_code "
  		+ "FROM "+Constants.KEYSPACE+".PRODUCT_PRICING "
  			+ "WHERE product_id = :productId")
  public abstract ProductPricing getPriceByproductId(@Param("productId") Integer paramInteger);
  
  @Query("UPDATE "+Constants.KEYSPACE+".PRODUCT_PRICING  "
  		+ "SET product_price = :productPrice, "
  		+ "update_dttm = :updateDttm, "
  		+ "update_user = :updateUser "
  		+ "WHERE product_id = :productId")
  public abstract void updatePrice(
						@Param("productId") Integer paramInteger, 
						@Param("productPrice") Double paramDouble, 
						@Param("updateDttm") Date paramDate, 
						@Param("updateUser") String paramString);
}
