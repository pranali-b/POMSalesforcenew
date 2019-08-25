package com.sfdc.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfdc.qa.base.TestBase;

public class checkYourEmailPage extends TestBase {
	@FindBy(xpath="//p[contains(text(),'We’ve sent you an email with a link to finish rese')]")
	WebElement validateCheckMailmsg;
	
	public checkYourEmailPage() {

		PageFactory.initElements(driver, this);
	}
	
	
	public String validateCheckMailMsgTest() {

		
		return driver.getTitle();
		
		
	}
}
