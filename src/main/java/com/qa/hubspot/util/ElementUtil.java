package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Nadeem Ahmed
 *
 */
/**
 * @author Nadeem Ahmed
 *
 */
public class ElementUtil {
	WebDriver driver;
/**
 * Method to find Element on webpage
 * @param driver
 */
public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
	WebElement element= null;
		try {
		 element = driver.findElement(locator);
		}
		catch(Exception e) {
			System.out.println("Exception Occured");
			System.out.println(e.getMessage());
		}
		return element;
	}
	/**
	 * This is method to click on any web element.
	 * @param locator
	 */
	public void  doClick(By locator) {
		try {
		getElement(locator).click();
		}
		catch(Exception e) {
			System.out.println("Exception Occured");
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * this is the metod for send keys
	 * @param locator
	 * @param value
	 */
	public void sendKeys(By locator, String value) {
	try {	
	getElement(locator).sendKeys(value);
	}
	catch(Exception e) {
		System.out.println("Exception Occured");
		System.out.println(e.getMessage());
	}
	}	
	public WebElement explicitWait(By locator, int TimeOuts) {
		WebDriverWait w = new WebDriverWait(driver, TimeOuts);
		WebElement element1 = w.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element1;
	}
	
	public String getTittleExplicit(String value,int TimeOuts ) {
		
		WebDriverWait w = new WebDriverWait(driver, TimeOuts);
		w.until(ExpectedConditions.titleContains(value));
		String tittle = driver.getTitle();
		return tittle;
		
	}
	
	public boolean isDisplayed(By locator) {
		try {
		return getElement(locator).isDisplayed();
		}
		catch (Exception e) {
			System.out.println("Exception Occured while fetching element");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public String getText(By locator) {
		try {
			return getElement(locator).getText();
		 }
		catch (Exception e) {
			System.out.println("Exception Occured while fetching text of element");
			System.out.println(e.getMessage());
			return null;
			
			
		}
	}
	
	public void doActionsClick(By locator) {
		Actions a = new Actions(driver);
		a.click(getElement(locator)).build().perform();
	}
	
	
		
	}
	
	


