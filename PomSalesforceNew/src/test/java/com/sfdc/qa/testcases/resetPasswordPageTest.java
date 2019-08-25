package com.sfdc.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sfdc.qa.base.TestBase;
import com.sfdc.qa.pages.checkYourEmailPage;
import com.sfdc.qa.pages.forgotPasswordPage;
import com.sfdc.qa.pages.homePage;
import com.sfdc.qa.pages.loginPage;
import com.sfdc.qa.pages.resetPasswordPage;

public class resetPasswordPageTest extends TestBase {
	
	resetPasswordPage resetpasswordpage;
	forgotPasswordPage forgotpasswordpage;


	public resetPasswordPageTest() {


		super();
	}
	@BeforeMethod
	public void setUp() {

		intilalization();
		forgotpasswordpage = new forgotPasswordPage();
		resetpasswordpage=forgotpasswordpage.forgotPasswordLink();
		
	}
	
	@Test(priority=1,enabled=true)
	public void enterUsernameAndContinueTest() throws InterruptedException {
		Thread.sleep(3000);
		resetpasswordpage.enterUsernameAndContinue(prop.getProperty("username"));
	}
	
	
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
