package com.sfdc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfdc.qa.base.TestBase;

public class forgotPasswordPage extends TestBase{
	@FindBy(id="forgot_password_link")
	WebElement usernameforgotlnkfield;
	
	public forgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public resetPasswordPage forgotPasswordLink() {
		usernameforgotlnkfield.click();
		return new resetPasswordPage();
	}
	
}
