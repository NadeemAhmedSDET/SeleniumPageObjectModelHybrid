package com.qa.hubspot.testpages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.page.Loginpage;
import com.qa.hubspot.util.Constants;

import junit.framework.Assert;

public class LoginpageTest {
	
	Basepage basepage;
	Properties prop;
	WebDriver driver;
	Loginpage lognpage;
	
	
	
	@BeforeTest
	public void setup() {
	basepage= new Basepage();
	prop =  basepage.initializeProperties();
	String browser = prop.getProperty("browser");
	driver = basepage.initializeDriver(browser);
	driver.get(prop.getProperty("url"));
	 lognpage = new Loginpage(driver);
	}
	
	
	@Test(priority = 1)
	public void VerifyloginpagetittleTest() {
		
		Assert.assertEquals(lognpage.getpagetittle(), Constants.Login_PAGE_TITLE);
	}
	@Test(priority = 2)
	public void VerifySignuplinkPresent() {
		Assert.assertTrue(lognpage.verifySignuplink());
		
	}
	@Test(priority = 3)
	public void Logincheck() {
		lognpage.Dologin(prop.getProperty("uname"), prop.getProperty("passwd"));
		
	}
	@AfterTest
	public void teardown() {
		
		driver.quit();
	}
	

}
