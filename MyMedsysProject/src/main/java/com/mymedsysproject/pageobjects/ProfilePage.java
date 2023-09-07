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
public class ProfilePage extends BaseClass {


	public ProfilePage() {
		PageFactory.initElements(getDriver(), this);
	}
	public String getprofileUrl() {
		 String title = getDriver().getCurrentUrl();
		 return title;
	}
}
