package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage {

	WebDriver driver;
	Properties prop;
	
	
	
	/**
	 * Use this method for WebDriver driver initializing
	 * @param BrowserName
	 * @return WebDriver driver
	 */
	public WebDriver initializeDriver(String BrowserName) {
		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","F:/KT/chromedriver/chromedriver.exe" );
	driver = new ChromeDriver();
			}
		else if (BrowserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			}
		else {
			System.out.println(BrowserName +"Invalid Browser name");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
		
	}
	
	/**
	 * Use this method to initialize config.properties file 
	 * @return Properties prop
	 */
	public Properties initializeProperties() {
		
		 prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("F:/JavaParctice/frmwrk/src/main/java/com/qa/hubspot/config/config.properties");
		
			prop.load(ip);
			}
		catch (FileNotFoundException e) {
			System.out.println("File not found please check and rectify the mistake.....");
		}
		 catch (IOException e) {
				System.out.println("Properties could not be loaded....");
			 }
		
		return prop;
	}
	
}
