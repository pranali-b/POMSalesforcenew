package com.sfdc.qa.base;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.sfdc.qa.config.testUtil;



public class TestBase{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {


		try {
			prop=new Properties();
			FileInputStream fis= new FileInputStream("/Users/pranalibankar/eclipse-workspace"
			+"/PomSalesforce/src/main/java/com/sfdc/qa/config/configuration.properties");
			prop.load(fis);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	public static void intilalization() {


		

		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","./src/main/resources/Utility/chromedriver");
			driver=new ChromeDriver();
		}else if(browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","./src/main/resources/Utility/geckodriver");
			driver=new FirefoxDriver();
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		

	}
}
