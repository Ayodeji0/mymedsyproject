/**
 * 
 */
package com.mymedsysproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mymedsysproject.base.BaseClass;

/**
 * 
 *Author: Ayodeji
  * Date: 2023
 */
public class PatientManagementPage extends BaseClass {
	
	
	
//	LoginPage loginPage;
//	DashboardPage dashboardPage;
//
//	@BeforeMethod(groups= {"Smoke","Regression","Sanity"})
//	public void setUp(String browser) {
//		launchApp(browser);
//	}
//
//	@AfterMethod(groups= {"Smoke","Regression","Sanity"})
//	public void tearDown() {
//		driver.quit();
//	}

	
	public PatientManagementPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getpatientTitle() {
		 String mytitle = getDriver().getCurrentUrl();
		 return mytitle;
	}

	
}
