package com.sfdc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfdc.qa.base.TestBase;

public class resetPasswordPage extends TestBase {
	
	
	@FindBy(xpath="//input[@id='un']")
	WebElement continuebutton;

	@FindBy(id="un")
	WebElement username;


	public resetPasswordPage() {



		PageFactory.initElements(driver, this);
	}
	
	public checkYourEmailPage enterUsernameAndContinue(String un) throws InterruptedException {

		Thread.sleep(3000);
		username.sendKeys(un);
		Thread.sleep(3000);
		continuebutton.click();
		Thread.sleep(3000);
		return new checkYourEmailPage();
	}
	
	
	
}
