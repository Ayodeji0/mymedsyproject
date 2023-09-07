/**
 * 
 */
package com.mymedsysproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mymedsysproject.base.BaseClass;

/**
 * 
 *Author: Ayodeji
  * Date: 2023
 */
public class SignOutPage extends BaseClass{


	public SignOutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public  String logout() {
		String signout = getDriver().getCurrentUrl();
		return signout;
	}
}
