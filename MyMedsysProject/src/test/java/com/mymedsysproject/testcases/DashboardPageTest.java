/**
 * 
 */
package com.mymedsysproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mymedsysproject.base.BaseClass;
import com.mymedsysproject.pageobjects.DashboardPage;
import com.mymedsysproject.pageobjects.DemographyPage;
import com.mymedsysproject.pageobjects.LoginPage;
import com.mymedsysproject.pageobjects.NotificationPage;
import com.mymedsysproject.pageobjects.PatientCreationPage;
import com.mymedsysproject.pageobjects.PatientManagementPage;
import com.mymedsysproject.pageobjects.ProfilePage;
import com.mymedsysproject.pageobjects.SignOutPage;
import com.mymedsysproject.utility.Log;
import com.mymedsysproject.utility.ReadData;

/**
 * 
 * Author: Ayodeji Date: 2023
 */
public class DashboardPageTest extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	PatientManagementPage patientPage;
	NotificationPage notificationPage;
	PatientCreationPage patientCreationPage;
	ProfilePage profilePage;
	SignOutPage signoutPage;
	
	@Parameters("browser")
	@BeforeMethod()
	public void setUp(String browser) {
		launchApp(browser);
	}

	
	@AfterMethod(groups= {"Smoke","Regression","Sanity"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups="Sanity")
	public void verifyDashboardLogo() throws InterruptedException {
		Log.startTestCase("verifyDashboardLogo");
		loginPage = new LoginPage();
		dashboardPage = loginPage.SignIn(props.getProperty("username"), props.getProperty("password"),
				props.getProperty("practiceid"));
		Log.info("User Enter Their Details");
		boolean logo2 = dashboardPage.logoVerification();
		Log.info("The Test Confirm The Logo Is Present");
		System.out.println("This is logo" + logo2);
		Assert.assertTrue(logo2);
		Log.info("Test Passed");
		Log.endTestCase("verifyDashboardLogo");

	}

	
//	public void dropdown() throws InterruptedException {
//		
//			loginPage = new LoginPage(driver);
//			dashboardPage = loginPage.SignIn(props.getProperty("username"), props.getProperty("password"),
//				props.getProperty("practiceid"));
//			Thread.sleep(5000);
//			dashboardPage.selectePatient();
//		
//	}
//	If i want to run the parameters from excel meaning data driven test i will use dataprovider and as well pass the page to be returned as 4th parameter 
	@Test(groups = "Smoke")
	public void selectPatientDropdown() throws InterruptedException {
		Log.startTestCase("selectPatientDropdown");
		loginPage = new LoginPage();
		Log.info("User Enters Their Details");
		dashboardPage = loginPage.SignIn(props.getProperty("username"), props.getProperty("password"),
				props.getProperty("practiceid"));
		Thread.sleep(5000);
		Log.info("The Action Is Carried Out Here");
		dashboardPage.selectOption("Patients Charts");	
		Log.info("Test Passed");
		Log.endTestCase("selectPatientDropdown");
	}
	
	@Test(groups= {"Smoke","Sanity"})
	public void managePatient() throws InterruptedException {
		Log.startTestCase("managePatient");
		loginPage = new LoginPage();
		Log.info("User Enters Their Details");
		dashboardPage = loginPage.SignIn(props.getProperty("username"), props.getProperty("password"),
			props.getProperty("practiceid"));
		 patientPage = dashboardPage.patientManage();
		 String actualurl = patientPage.getpatientTitle();
			String excpected = "https://dev-ehrpm.automedsys.net/patient";
			Log.info("This Is To Confirm If The Url is Correct Or Not");
			Assert.assertEquals(actualurl, excpected);
			Log.info("Test Passed");
			Log.endTestCase("managePatient");
	}

	@Test(groups = {"Regression","Sanity"})
	public void patientsearch() throws InterruptedException {
		Log.startTestCase("patientsearch");
		loginPage = new LoginPage();
		Log.info("User To Enter Details Here");
		dashboardPage = loginPage.SignIn(props.getProperty("username"), props.getProperty("password"),
				props.getProperty("practiceid"));
		Thread.sleep(5000);
		Log.info("Patient Name In Search To Be Entered Here");
		patientPage = dashboardPage.searchPatient("Tunji olalere");
		String actualUrl = patientPage.getpatientTitle();
		String expected = "https://dev-ehrpm.automedsys.net/patient/demography";
		Log.info("This Is To Confirm The Url");
		Assert.assertEquals(actualUrl, expected);
		Log.info("Test Passed");
		Log.endTestCase("patientsearch");

	}

	@Test(groups ="Sanity")
	public void clickOndashboardBellicon() throws InterruptedException {
		Log.startTestCase("clickOndashboardBellicon");
		loginPage = new LoginPage();
		Log.info("User To Enter Details Here");
		dashboardPage = loginPage.SignIn(props.getProperty("username"), props.getProperty("password"),
				props.getProperty("practiceid"));
		Thread.sleep(5000);
		notificationPage = dashboardPage.NotificaionBtn();
		String actual = notificationPage.getnotificationTitle();
		String expected = "https://dev-ehrpm.automedsys.net/notifications";
		Log.info("To The Url Is Correct");
		Assert.assertEquals(actual, expected);
		Log.info("Test Passed");
		Log.endTestCase("clickOndashboardBellicon");
	}

	@Test(groups="Regression")
	public void headerpatientbtn() throws InterruptedException {
		Log.startTestCase("headerpatientbtn");
		loginPage = new LoginPage();
		Log.info("User To Enter Their Details Here");
		dashboardPage = loginPage.SignIn(props.getProperty("username"), props.getProperty("password"),
				props.getProperty("practiceid"));
		Thread.sleep(5000);
		patientPage = dashboardPage.patientNavigations();
		String actualurl = patientPage.getpatientTitle();
		String excpected = "https://dev-ehrpm.automedsys.net/patient";
		Log.info("This Is To Confirm The Url Is Correct");
		Assert.assertEquals(actualurl, excpected);
		Log.info("Test Passed");
		Log.endTestCase("headerpatientbtn");
	}
	
	// Testing 
	
	@Test(groups="Sanity")
	public void profileAccount() throws InterruptedException {
		Log.startTestCase("profileAccount");
		loginPage = new LoginPage();
		Log.info("User To Enter Their Details ");
		dashboardPage = loginPage.SignIn(props.getProperty("username"), props.getProperty("password"),
				props.getProperty("practiceid"));
		profilePage = dashboardPage.userAccountBtn();
		String actualurl = profilePage.getprofileUrl();
		String expectedurl = "https://dev-ehrpm.automedsys.net/profile";
		Assert.assertEquals(actualurl,  expectedurl);
		Log.info("To Confirm The Url Is Correct");
		Log.info("Test Passed");
		Log.endTestCase("profileAccount");
	}

	//Testing again
	@Test(groups="Smoke")
	public void userAccountSignOutBtn() throws InterruptedException {
		Log.startTestCase("userAccountSignOutBtn");
		loginPage = new LoginPage();
		Log.info("User Enters Their Details Here");
		dashboardPage = loginPage.SignIn(props.getProperty("username"), props.getProperty("password"),
				props.getProperty("practiceid"));
		     signoutPage = dashboardPage.userAccountBtn2();
		     String actualurl=loginPage.getCurrentUrl();
		     String expectedurl ="https://dev-ehrpm.automedsys.net/";
		     Log.info("This Is To Confirm The Url");
		     Assert.assertEquals(actualurl, expectedurl);
		     Log.info("Test Passed");
		     Log.endTestCase("userAccountSignOutBtn");
		
	}
	
	@Test(groups = {"Regression", "Sanity"})
	public void newpatientbtn() throws InterruptedException {
		Log.startTestCase("newpatientbtn");
		loginPage = new LoginPage();
		Log.info("User To Enter Their Details");
		dashboardPage = loginPage.SignIn(props.getProperty("username"), props.getProperty("password"),
				props.getProperty("practiceid"));
		Thread.sleep(5000);
		patientCreationPage = dashboardPage.newpatient();
		String actualTitle = patientCreationPage.createpatientTitle();
		String expectedTitle = "https://dev-ehrpm.automedsys.net/patient/newPatient";
		Log.info("This Is To Confirm The Url");
		Assert.assertEquals(actualTitle, expectedTitle);
		Log.info("Test Passed");
		Log.endTestCase("newpatientbtn");
	}

}
