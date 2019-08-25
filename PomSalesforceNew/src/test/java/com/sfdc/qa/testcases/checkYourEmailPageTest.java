package com.sfdc.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sfdc.qa.base.TestBase;
import com.sfdc.qa.pages.checkYourEmailPage;
import com.sfdc.qa.pages.forgotPasswordPage;
import com.sfdc.qa.pages.resetPasswordPage;

import junit.framework.Assert;

public class checkYourEmailPageTest extends TestBase {
	
	resetPasswordPage resetpasswordpage;
	checkYourEmailPage checkyouremailpage;
	forgotPasswordPage forgotpasswordpage;
	
	public checkYourEmailPageTest() {

		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {


		intilalization();
		//checkyouremailpage= new checkYourEmailPage();
		
		resetpasswordpage= new resetPasswordPage();
		forgotpasswordpage = new forgotPasswordPage();
		
		resetpasswordpage=forgotpasswordpage.forgotPasswordLink();
		checkyouremailpage=resetpasswordpage.enterUsernameAndContinue(prop.getProperty("username"));
		
	}
	
	@Test(priority=1,enabled=false)
	public void validateCheckMailMsgpageTest() {


		String actualvalidateMsg=checkyouremailpage.validateCheckMailMsgTest();
		String expected="We’ve sent you an email with a link to finish resetting your password.";
		Assert.assertEquals(actualvalidateMsg,expected);
	}
	
	@AfterMethod
	public void tearDown() {


		driver.quit();
	}
}
