package com.qa.hubspot.testpages;

import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.page.Contactspage;
import com.qa.hubspot.page.Homepage;
import com.qa.hubspot.page.Loginpage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ExcelUtility;

import junit.framework.Assert;

public class ContactspageTest {
	Basepage basepage;
	Properties prop;
	WebDriver driver;
	Loginpage loginpage;
	Homepage hp;
	Contactspage cp;
	
	
	
	
	@BeforeMethod
	public void setup() {
	basepage = new Basepage();
	
	prop = basepage.initializeProperties();
	String browser = prop.getProperty("browser");
	driver = basepage.initializeDriver(browser);
	driver.get(prop.getProperty("url"));
	
	loginpage = new Loginpage(driver);
	hp = loginpage.Dologin(prop.getProperty("uname"), prop.getProperty("passwd"));
	cp = hp.gotoContactpage();

}
	@Test(priority =1)
	public void verifytitle() {
		
		String title = cp.getpageTitle();
		System.out.println("Title of the page is :"+ title );
		
		Assert.assertEquals(cp.getpageTitle(), Constants.Contacts_PAGE_TITLE);
	}
	
	@DataProvider
	public Object[][] getexceldata(){
		Object data [][] = ExcelUtility.getTestaData(Constants.Contact_sheet_name);
		return data;
	}
		
	
	@Test(priority =2, dataProvider = "getexceldata")
	public void CreateContact(String email, String firstname, String lastname, String jobtitle) {
		cp.createNewContact(email,firstname, lastname, jobtitle );
		
		
	}
	
	@AfterMethod
	
public void TearDown() {
		
		driver.quit();
	}
	
}
