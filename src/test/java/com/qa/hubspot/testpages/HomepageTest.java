package com.qa.hubspot.testpages;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.page.Homepage;
import com.qa.hubspot.page.Loginpage;
import com.qa.hubspot.util.Constants;
import junit.framework.Assert;

public class HomepageTest {
	
	Basepage basepage;
	Properties prop;
	WebDriver driver;
	Loginpage loginpage;
	Homepage hp;
	
	@BeforeTest
	public void setup() {
	basepage = new Basepage();
	
	prop = basepage.initializeProperties();
	String browser = prop.getProperty("browser");
	driver = basepage.initializeDriver(browser);
	driver.get(prop.getProperty("url"));
	
	loginpage = new Loginpage(driver);
	hp = loginpage.Dologin(prop.getProperty("uname"), prop.getProperty("passwd"));
		
		
	}
	@Test (priority = 1)
	public void homepageTitleTest() {
		Assert.assertEquals(hp.getHomepageTitle(), Constants.Home_PAGE_TITLE);	
	}
	@Test (priority = 2)
	public void headerPresent() {
		
		Assert.assertTrue(hp.isHeaderPresent());
		Assert.assertEquals(hp.headerGetText(), Constants.Home_PAGE_HEADER);
	}
	@Test (priority = 3)
	public void Acountpresent() {
		Assert.assertTrue(hp.isAccountNamePresent());
		Assert.assertEquals(hp.AccountName(), prop.getProperty("accountName"));
		}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	
	

}
