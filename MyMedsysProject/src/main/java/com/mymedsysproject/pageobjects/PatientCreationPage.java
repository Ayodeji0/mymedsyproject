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
public class PatientCreationPage extends BaseClass {

	public PatientCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String createpatientTitle() {
		 String mytitle = getDriver().getCurrentUrl();
		 return mytitle;
	}
}
