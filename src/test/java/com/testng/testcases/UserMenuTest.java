package com.testng.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.pages.LoginPage;
import com.testng.pages.UserMenuPage;
import com.testng.utilities.PropertiesReader;
import com.testng.utilities.ScreenShotUtlities;

public class UserMenuTest extends BaseTest {
	
	
	UserMenuPage userMenu;
	LoginPage login;
	
	WebDriver driver;
	PropertiesReader properties;
	ScreenShotUtlities screenshot = new ScreenShotUtlities();
	String username01,password01;
	
@BeforeMethod
	
	public void beforeMethod(){
		
		driver = launchBrowser();
		
		userMenu = new UserMenuPage(driver);
		
		userMenu.userNameUserMenu();
	
		
		
	}

@Test(priority=1)
	public void clickOnUserNameNavBtnTC05() throws InterruptedException{
		
		userMenu.UserNameDropDown();
		
		//userMenu.validateTC05();
	}

@Test(priority=2)
	public void myProfileOptionTC06() throws InterruptedException{
		//this needs to be worked on later-- original prog is incomplete
		userMenu.UserNameDropDown();
		Thread.sleep(2000);
		
	}

@Test(priority=3)
	public void mySettingsOptionTC07() throws InterruptedException{
	
		userMenu.UserNameDropDown();
		userMenu.MySettingsClick();
		userMenu.personalLinkSel();
		userMenu.loginHistoryLinkSel();
		userMenu.downldLoginHistoryLink();
		//Thread.sleep(2000);
		userMenu.displayLayoutClick();
		userMenu.customMyTabsLink();
		//screenshot.takeScreenShot(driver);
		userMenu.removeTabsTest();
		//Thread.sleep(5000);
		userMenu.alterEmailSettings();
		//Thread.sleep(5000);
		userMenu.testActivityReminder();
		
	}

@Test(priority=4)
	public void devloperConsoleOptionTC08(){
		// here the dev console opens up but cannot switch driver to the devConsole to close it 
		// the parent window immediately closes and the run is failed
		userMenu.UserNameDropDown();
		userMenu.DevConClick();
		//userMenu.DevConOperations();
	}

@Test(priority = 5)

	public void logOutTC09() {
		userMenu.UserNameDropDown();
		userMenu.logOutSelect();
		
}

@AfterMethod

	public void teardown() {
		//screenshot.takeScreenShot(driver);
		closebrowser();
}

	
	
}
