package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class Contactspage extends Basepage {
	
	WebDriver driver;
	ElementUtil el;
	
	
	
	By create_contact_btn = By.xpath("//span[contains(text(), 'Create contact')]");
	By Email = By.xpath("//input[@data-field = 'email']");
	By FirstName = By.xpath("//input[@data-field = 'firstname']");
	By LastName = By.xpath("//input[@data-field = 'lastname']");
	By JobTitle = By.xpath("//input[@data-field = 'jobtitle']");
	
	By submit_btn = By.xpath("(//span[contains(text(),'Create contact')])[2]");
	
	public Contactspage(WebDriver driver) {
		this.driver = driver;
	 el = new ElementUtil(driver);
	 
	}
	public String getpageTitle(){
		return el.getTittleExplicit(Constants.Contacts_PAGE_TITLE, 15);
	}
	public void createNewContact(String email, String Fn, String Ln, String Jt) {
		el.explicitWait(create_contact_btn, 15);
		el.doClick(create_contact_btn);
		
		
		el.explicitWait(Email, 15);
		el.sendKeys(Email, email);
		
		el.explicitWait(FirstName, 15);
		el.sendKeys(FirstName, Fn);
		
		
		el.explicitWait(LastName, 15);
		el.sendKeys(LastName, Ln);
		
		
		el.explicitWait(JobTitle, 15);
		el.sendKeys(JobTitle, Jt);
		
		
		el.explicitWait(submit_btn, 15);
		el.doActionsClick(submit_btn);
		
	}
}
