/**
 * 
 */
package com.mymedsysproject.base;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mymedsysproject.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 *Author: Ayodeji
  * Date: 2023
 */
public class BaseClass {
	public static Properties props;
//	 public static WebDriver driver;
	
	// ThreadLocal
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite()
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		
		try {
			props = new Properties();
			FileInputStream fi = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			props.load(fi);
			System.out.print("driver" + driver);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
//	 ThreadLocal Driver
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	
	 public static void launchApp(String browserName) {

	    if (browserName.equalsIgnoreCase("Chrome")) {
	        WebDriverManager.chromedriver().setup();
	        // set to threadlocal
	        driver.set(new ChromeDriver());
	    } else if (browserName.equalsIgnoreCase("FireFox")) {
	    	 WebDriverManager.firefoxdriver().setup();
	    	 driver.set(new FirefoxDriver());
	    } else if (browserName.equalsIgnoreCase("Edge")) {    
	    	WebDriverManager.edgedriver().setup();
	    	driver.set(new EdgeDriver());
	    }else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
	    
	    getDriver().manage().window().maximize();
		//Delete all the cookies
	    getDriver().manage().deleteAllCookies();
		//Implicit TimeOuts
	    int Implictime = Integer.parseInt(props.getProperty("implicitWait"));
	    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Implictime));
		//PageLoad TimeOuts
	   int Pagetimeout = Integer.parseInt(props.getProperty("pageLoadTimeOut"));
	   getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Pagetimeout));
		//Launching the URL
	   getDriver().get(props.getProperty("testUrl"));
	    

	  
	}

	 @AfterSuite()
		public void afterSuite() {
			ExtentManager.endReport();
		}
	/**
	 * @return
	 */

	
	
//	    For simulating mobile view and tab view we can make use of the four lines of code by getting the variable from config file 
	    
//	    int windowWidth = Integer.parseInt(props.getProperty("windowWidth"));
//     int windowHeight = Integer.parseInt(props.getProperty("windowHeight"));
//     
     // Set the size of the browser window
//     Dimension windowSize = new Dimension(windowWidth, windowHeight);
//     myDriver().manage().window().setSize(windowSize);
	
	
	

	
}
