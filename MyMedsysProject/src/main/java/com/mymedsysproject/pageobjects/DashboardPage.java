/**
 * 
 */
package com.mymedsysproject.pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.mymedsysproject.actiondriver.Action;
import com.mymedsysproject.base.BaseClass;

/**
 * 
 *Author: Ayodeji
  * Date: 2023
 */
public class DashboardPage extends BaseClass {

	@FindBy(xpath="//img[@alt='COMPANY lOGO']")
	private WebElement dashboardLogo;
	@FindBy(xpath="//input[@id='combo-box-demo']") 
	private WebElement searchBox;
	@FindBy(xpath="//li[text()=\"Profile\"]")
	private WebElement profileBtn;
	@FindBy(xpath ="//li[text()=\"Sign out\"]")
	private WebElement signoutBtn;
	@FindBy(xpath="//button[@aria-label='fullscreen']//span[1]//*[name()='svg']")
	private WebElement searchBtn;
	@FindBy(xpath="//body/div[@id='root']/div/div/div/header/div/div/div/div/button[1]")
	private WebElement headerpatientBtn;
	@FindBy(xpath="//body/div[@id='root']/div/div/div/header/div/div/div/div/button[2]")
	private WebElement headernewpatientBtn;
	@FindBy(xpath="//header//button[3]//span[1]//*[name()='svg']")
	private WebElement notificationBtn;
	@FindBy(xpath="//img[@alt='patient']")
	private WebElement patientcreationBtn;
	@FindBy(xpath="//body/div[@id='root']/div/div/div/div/div[2]") 
	private WebElement menuBtn;
	@FindBy(xpath ="//li[normalize-space()='Patients']")
	private WebElement patientdropdownBtn;
	@FindBy(xpath ="//li[normalize-space()='Patients Charts']")
	private WebElement patientchartBtn;
	@FindBy(xpath="//body/div[@id='root']/div/div/div/header/div/div/div/form[@autocomplete='off']/div/button[1]")
	private WebElement dropdowbBtn;
	@FindBy(xpath="//button[@aria-label='account of current user']")
	WebElement userBtn;
//	@FindBy(xpath ="//li[2]") WebElement profileBtn;
	@FindBy(xpath = "//ul[@role='menu']/li")
    private List<WebElement> listOfElements;
	@FindBy (xpath="//a[2]") 
	private WebElement patientmanagementBtn;
	
	
	
	
	public DashboardPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean logoVerification() {
		 return Action.isDisplayed(getDriver(), dashboardLogo);
	}
	
//	 To select from patient or patient chart dropdown
	
	public void dropt() {
		Action.click(getDriver(), dropdowbBtn);
	}
	
	public void selectOption( String patientOptions) {
		   dropt();
		 if(patientOptions.equalsIgnoreCase("Patients")) {
				Action.click(getDriver(), patientdropdownBtn);
				System.out.println("did you get clicked");
			} else if(patientOptions.equalsIgnoreCase("Patient Charts")) {
				Action.click(getDriver(), patientchartBtn);;
			}
	}
	
	
//	 This is for the searchbox
	
	public PatientManagementPage searchPatient(String PatientName) {
		Action.type(searchBox, PatientName);
		Action.click(getDriver(), searchBtn);
		return new PatientManagementPage();
	}
	
//	 This is for the dashboard patient creation button
	public PatientManagementPage patientNavigations() {
		Action.click(getDriver(), headerpatientBtn);
		return new PatientManagementPage();
	}
	
//	 This is for dashboard new patient navigation btn
	public PatientCreationPage newpatient() {
		Action.click(getDriver(), headernewpatientBtn);
		return new  PatientCreationPage();
	}
	
	
//	 This is for dashboard Navigation button
	public NotificationPage NotificaionBtn()  {
		Action.click(getDriver(), notificationBtn);
		return new NotificationPage();
	}

 // This is to click the patient sidemenu and navigate to patientmanagement page
	
	public PatientManagementPage patientManage() {
		Action.click(getDriver(), patientmanagementBtn);
		return new PatientManagementPage();
	}
	
	public String getdashboardUrl() {
		 String title = getDriver().getCurrentUrl();
		 return title;
	}
	// This is for dropdown from bootstrap that has multiple elements
//	public ProfilePage userAccount() {
//		Action.click(driver, userBtn);
//		for (WebElement webElement : listOfElements) {
//			if(webElement.getText().trim().equalsIgnoreCase("profile")){
//				Action.click(driver, webElement);
//				return new ProfilePage();
//			}
//		}
//		return null;
//	}
	
	public ProfilePage userAccountBtn() {
		Action.click(getDriver(), userBtn);
		Action.fluentWait(getDriver(), profileBtn, 10);
		return new ProfilePage();
	}
	
	public SignOutPage userAccountBtn2() {
		Action.click(getDriver(), userBtn);
		Action.fluentWait(getDriver(), signoutBtn, 10);
		return new SignOutPage();
	}

	
	
	
	
}
