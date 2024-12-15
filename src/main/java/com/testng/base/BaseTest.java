package com.testng.base;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.testng.log.Log;
import com.testng.utilities.PropertiesReader;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Initial methods that needs to be done at the beginning of each test
 * 
 * 
 * 
 * 
 * 
 * 
 */
 


public class BaseTest {
	
	  protected WebDriver driver ;
	  PropertiesReader properties ;
	  String browserName;
	  String urlLink;
	
	public WebDriver launchBrowser() {
		Log.info("Tests is starting!");
		properties = new PropertiesReader();
		browserName = properties.getProperty("browser");
		
		if(driver ==null) {
			
			if(browserName.equalsIgnoreCase("chrome")) {
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
			}else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			
		}
		urlLink = properties.getProperty("url");
		driver.get(urlLink);
		return driver;
		
	}
	
	public void closebrowser() {
		Log.info("Tests are ending!");
		driver.close();
		driver = null;
	}

}
