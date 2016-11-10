package com.myretail.common.utility;

import java.util.Enumeration;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class SystemPropertyUtil
  implements InitializingBean
{
  private static final Logger logger = LoggerFactory.getLogger(SystemPropertyUtil.class);
  
  public void afterPropertiesSet()
    throws Exception
  {
    String env = System.getProperty("env");
    if ((null == env) || (env.isEmpty())) {
      System.setProperty("env", "local");
    }
    logger.info("System properties:");
    logger.info("-------------------------------------------------------");
    Properties p1 = System.getProperties();
    String key1;
    String value;
    for (Enumeration keys1 = p1.keys(); keys1.hasMoreElements(); logger.info(key1 + " = " + value))
    {
      key1 = (String)keys1.nextElement();
      value = (String)p1.get(key1);
    }
    logger.info("-------------------------------------------------------");
  }
}
