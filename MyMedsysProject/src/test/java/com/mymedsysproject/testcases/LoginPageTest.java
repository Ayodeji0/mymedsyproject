/**
 * 
 */
package com.mymedsysproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mymedsysproject.base.BaseClass;
import com.mymedsysproject.pageobjects.DashboardPage;
import com.mymedsysproject.pageobjects.LoginPage;
import com.mymedsysproject.utility.Log;
import com.mymedsysproject.utility.ReadData;

/**
 * 
 * Author: Ayodeji Date: 2023
 */
public class LoginPageTest extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;
    @Parameters("browser")
	@BeforeMethod()
	public void setUp(String browser) {
		launchApp(browser);
	}

	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}

	@Test()
	public void VerifyLogotest() {
		Log.startTestCase("verifylogotest");
		loginPage = new LoginPage();
		boolean logo = loginPage.isLogoDisplayed();
		Log.info("Logo Confirmed");
		Assert.assertTrue(logo);
		Log.info("VerifyLogotest Was Successful");
		Log.info("Test Passed");
		Log.endTestCase("verifylogotest");
	}

	@Test(dataProviderClass = ReadData.class, dataProvider = "logindata")
	public void LoginTest(String username, String password, String practiceid) throws InterruptedException {
		Log.startTestCase("LoginTest");
		loginPage = new LoginPage();
		Log.info("User Enter Their Details");
		dashboardPage = loginPage.SignIn((username), (password), (practiceid));
		Thread.sleep(5000);
		Log.info("DashBaoard Url Is Confirmed");
		System.out.println(getDriver().getCurrentUrl());
		String actual = dashboardPage.getdashboardUrl();
		String expected = "https://dev-ehrpm.automedsys.net/dashboard";
		Assert.assertEquals(actual, expected);
		Log.info("LoginTest Test Completed");
		Log.endTestCase("LoginTest");

	}

}

//@Test
//public void Login() throws InterruptedException {
//	loginpage = new LoginPage(driver);
//	dashboardpage = loginpage.Login(props.getProperty("username"), props.getProperty("password"), props.getProperty("practiceId"));
//	Thread.sleep(3000);
//	String actualUrl = driver.getCurrentUrl();
//	String expectedUrl = "https://dev-ehrpm.automedsys.net/dashboard";
//	System.out.println(driver.getCurrentUrl());
//	System.out.println(driver.getTitle());
//	Assert.assertEquals(actualUrl, expectedUrl);
//	 This is to test invalid login reference number
//	Assert.assertTrue(loginpage.errormessage(), "unable to login user or invalid practice reference number");

//}

/*
 * @DataProvider(name = "test1") public Object[][] createData1() { return new
 * Object[][] { { "Cedric", new Integer(36) }, { "Anne", new Integer(37)}, }; }
 * This method is gotten from TestNg documantations it can be used if the test
 * cases are not much so as not to make things complex
 */
