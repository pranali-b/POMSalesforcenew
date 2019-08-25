package com.sfdc.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sfdc.qa.base.TestBase;
import com.sfdc.qa.pages.forgotPasswordPage;
import com.sfdc.qa.pages.loginPage;
import com.sfdc.qa.pages.resetPasswordPage;

public class forgotPasswordTest extends TestBase{
	
	
	resetPasswordPage resetpasswordpage;
	forgotPasswordPage forgotpasswordpage;

	public forgotPasswordTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intilalization();
		forgotpasswordpage =new forgotPasswordPage();
	}
	
	@Test(priority=1,enabled=true)
	public void forgotPasswordLinkTest() {
		forgotpasswordpage.forgotPasswordLink();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
