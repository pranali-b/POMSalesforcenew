package com.sfdc.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sfdc.qa.base.TestBase;
import com.sfdc.qa.pages.homePage;
import com.sfdc.qa.pages.loginPage;

import junit.framework.Assert;

public class homePageTest extends TestBase{

	loginPage loginpage;
	homePage homepage;

	public homePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		intilalization();
		loginpage =new loginPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));	
	}

	@Test(priority=1,enabled=false)
	public void homePageTitleValidationTest() throws InterruptedException {

		String actualhomePageTitle=homepage.homePageTitleValidation();
		String expectedHomePageTitle="Home Page ~ Salesforce - Developer Edition";
		Assert.assertEquals(actualhomePageTitle, expectedHomePageTitle,"Home page title not matched");
	}

	@Test(priority=2,enabled=true)
	public void clickuserLabelTest() throws InterruptedException {
		Thread.sleep(3000);
		homepage.clickuserLabel();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
