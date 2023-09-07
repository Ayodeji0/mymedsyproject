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
public class NotificationPage extends BaseClass {
	

	public NotificationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getnotificationTitle() {
		 String notificationtitle = getDriver().getCurrentUrl();
		 return notificationtitle;
	}


}

//public Login(WebDriver driver){
//    this.driver = driver;
//    PageFactory.initElements(driver, this);
//
//}