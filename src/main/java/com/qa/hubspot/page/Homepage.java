package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class Homepage extends Basepage {
	
	WebDriver driver;
	ElementUtil el;
	//1. Page Library/ page repo
	By header =  By.className("private-page__title");
	By acountmenu = By.xpath("//a[@id = 'account-menu']");
	By AccountName = By.xpath("//div[@class = 'user-info-name']");
	
	By ContactsMain = By.xpath("(//li//a[@id = 'nav-primary-contacts-branch'])[1]");
	By Contactssec = By.xpath("(//li//a[@id = 'nav-secondary-contacts'])[1]");
	
	
	//2. Page Constructor
	public Homepage(WebDriver driver) {
		this.driver = driver;
		
		 el = new ElementUtil(driver);
	}
	//3. page Action
	public String getHomepageTitle() {
		return el.getTittleExplicit(Constants.Home_PAGE_TITLE, 15);
	}
	public boolean isHeaderPresent() {
		el.explicitWait(header, 15);
		return el.isDisplayed(header);
		}
	public String headerGetText() {
		return el.getText(header);
		}
	public boolean isAccountNamePresent() {
		el.doClick(acountmenu);
		return el.isDisplayed(AccountName);
	}
	public String AccountName() {
		return el.getText(AccountName);
	}
	public void OpenContacts() {
		el.explicitWait(ContactsMain, 15);
		el.doClick(ContactsMain);
		el.explicitWait(Contactssec, 15);
		el.doClick(Contactssec);
	}
	public Contactspage gotoContactpage() {
		OpenContacts();
		return new Contactspage(driver);
	}
}
