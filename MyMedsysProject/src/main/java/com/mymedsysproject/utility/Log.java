/**
 * 
 */
package com.mymedsysproject.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 *Author: Ayodeji
  * Date: 2023
 */
public class Log {
  private static Logger logger = LogManager.getLogger(Log.class);
  
  public static void startTestCase(String TestCaseName) {
      logger.info("=====================================" + TestCaseName + " TEST START=========================================");
      logger.info("");
  }

  public static void endTestCase(String TestCaseName) {
      logger.info("=====================================" + TestCaseName + " TEST END=========================================");
      logger.error("");
    
  }

  public static void info(String message) {
      logger.info(message);
      logger.fatal("");
      
  }

  public static void warn(String message) {
      logger.warn(message);
      logger.warn("");
     
  }

  public static void debug(String message) {
      logger.debug(message);
  }
  
  public static void fatal(String message) {
      logger.fatal(message);
  }
}
