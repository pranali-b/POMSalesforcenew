package com.sfdc.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sfdc.qa.base.TestBase;
import com.sfdc.qa.config.testUtil;
import com.sfdc.qa.pages.homePage;
import com.sfdc.qa.pages.loginPage;



public class loginPageTest extends TestBase{

	loginPage loginpage;
	homePage homepage;

	public loginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		intilalization();
		loginpage =new loginPage();
	}

	@Test(priority=1,enabled=true)
	public void loginvalidateTitleTest() {

		String actualTitle=loginpage.validateloginPageTitle();
		String expectedTitle="Login | Salesforce";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority=2,enabled=true)
	public void loginTest() throws InterruptedException {

		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	/*@Test(priority=3,enabled=false)
	public void validateLoginErrorTest() {
		String actual=loginpage.validateLoginError();
		String expected="Please enter your password.";
		Assert.assertEquals(actual,expected,"Login page title not matched");
	}*/
	
	@Test(priority=4,enabled=true)
	public void loginwithinvalidUnTest() throws InterruptedException{
		
		loginpage.loginInvalidUsername(prop.getProperty("invusername"));
	}

	@Test(priority=3,enabled=true)
	public void remeberMeWithUNnPWDTest() throws InterruptedException{

		loginpage.remeberMeWithUNnPWD(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public String[][] getSfdcTestData() throws IOException {
		String[][] data =(String[][]) testUtil.getSfdcTestData("login");
		return data;
		
	}
	
	@Test(priority=5,enabled=true,dataProvider="getSfdcTestData")
	public void loginInvalidUsernameAndPasswordTest(String username,String password) throws Exception{

		loginpage.loginInvalidUsernameAndPassword(username,password);
		
	}

	
	@AfterMethod
	public void tearDown() {

		driver.quit();
		
	}
}
