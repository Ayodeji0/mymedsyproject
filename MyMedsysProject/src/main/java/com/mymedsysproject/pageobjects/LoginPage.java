/**
 * 
 */
package com.mymedsysproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mymedsysproject.actiondriver.Action;
import com.mymedsysproject.base.BaseClass;

/**
 * 
 * Author: Ayodeji Date: 2023
 */
public class LoginPage extends BaseClass {

	@FindBy(id = "Username")
	private WebElement username;
	@FindBy(id = "Password")
	private WebElement password;
	@FindBy(xpath = "//input[@id='PracticeRefNumber']")
	private WebElement practiceId;
	@FindBy(xpath = "//span[@class='MuiButton-label']")
	private WebElement loginBtn;

	@FindBy(xpath = "//div[@class='jss19']//img[2]")
	private WebElement Logo;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean isLogoDisplayed() {
		return Action.isDisplayed(getDriver(), Logo);
	}

	public String getCurrentUrl() {
		String title = getDriver().getCurrentUrl();
		return title;
	}

	public DashboardPage SignIn(String Uname, String pswd, String pracM) throws InterruptedException {
		Action.type(username, Uname);
		Action.type(password, pswd);
		Action.type(practiceId, pracM);
		Action.click(getDriver(), loginBtn);
		return new DashboardPage();
	}

}
