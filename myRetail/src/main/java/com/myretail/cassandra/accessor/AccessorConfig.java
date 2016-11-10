package com.myretail.cassandra.accessor;

import com.datastax.driver.mapping.MappingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccessorConfig{
  @Autowired
  private MappingManager mappingManager;
  
  @Bean
  public ProductPriceAccessor productPriceAccessor() {
    return this.mappingManager.createAccessor(ProductPriceAccessor.class);
  }
}
