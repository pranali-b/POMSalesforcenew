package com.sfdc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfdc.qa.base.TestBase;

public class homePage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Pranali bb')]")
	WebElement usernameLabel;
	
	@FindBy(linkText="Logout")
	WebElement logoutlink;
	
	public homePage() {
		PageFactory.initElements(driver, this);
	}

	public loginPage clickuserLabel() throws InterruptedException {
		Thread.sleep(3000);
		usernameLabel.click();
		Thread.sleep(3000);
		logoutlink.click();
		Thread.sleep(3000);
		return new loginPage();
	}
	
	public String homePageTitleValidation() throws InterruptedException {
		Thread.sleep(3000);
		return driver.getTitle();
	}
	

}
