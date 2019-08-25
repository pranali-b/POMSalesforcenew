package com.sfdc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfdc.qa.base.TestBase;

public class loginPage extends TestBase {
	@FindBy(id="username")
	WebElement username;

	@FindBy(id="password")
	WebElement password;

	@FindBy(id="Login")
	WebElement login;
	
	@FindBy(id="error")
	WebElement loginerror;
	
	@FindBy(id="rememberUn")
	WebElement rememberme;
	
	
	public loginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateloginPageTitle() {

		return driver.getTitle();
	}
	
	public String validateLoginError() {

		
		return driver.getTitle();
	
	}
	
	public homePage login(String un,String pwd) throws InterruptedException {

		username.sendKeys(un);
		Thread.sleep(3000);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		login.click();
		return new homePage();
	}
	
	public void loginInvalidUsername(String un) throws InterruptedException{

		Thread.sleep(3000);
		username.sendKeys(un);
		Thread.sleep(3000);
		password.clear();
		login.click();
		Thread.sleep(3000);
		
	}
	
	public homePage remeberMeWithUNnPWD(String un,String pwd) throws InterruptedException {
		Thread.sleep(3000);
		username.sendKeys(un);
		Thread.sleep(3000);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		rememberme.click();
		Thread.sleep(3000);
		login.click();
		Thread.sleep(3000);
		return new homePage();
		
	}
	
	public void loginInvalidUsernameAndPassword(String invalidus, String invpassword) throws Exception {

		Thread.sleep(3000);
		username.sendKeys(invalidus);
		Thread.sleep(3000);
		password.sendKeys(invpassword);
		Thread.sleep(3000);
		login.click();
		
	}
	
}

