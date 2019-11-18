package com.qa.hubspot.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;
public class Loginpage extends Basepage {
	WebDriver driver;
	ElementUtil elementutil;
	// 1. page Object
	By email = By.id("username");
	By pwd = By.id("password");
	By submit = By.id("loginBtn");
	By signuplink = By.linkText("Sign up");
	//2. create a constructor
	public Loginpage (WebDriver driver) {
		this.driver = driver;
		
		 elementutil = new ElementUtil(driver);
		this.driver = driver;
	}
	
	//3. Page Action or page Method
	
	public String getpagetittle() {
		
		String tittle = elementutil.getTittleExplicit(Constants.Login_PAGE_TITLE, 15);
		System.out.println("Login page tittle : "+ tittle);
		return tittle;	
	}
	public boolean verifySignuplink() {
		return elementutil.isDisplayed(signuplink);
	}
	public Homepage Dologin(String UserName, String Password) {
		elementutil.getTittleExplicit(Constants.Login_PAGE_TITLE, 15);
		elementutil.sendKeys(email, UserName);
		elementutil.sendKeys(pwd, Password);
		elementutil.doClick(submit);
		return new Homepage(driver);
	} 
}
