package com.testng.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.pages.AccountsPage;
import com.testng.pages.LoginPage;
import com.testng.pages.UserMenuPage;
import com.testng.utilities.PropertiesReader;
import com.testng.utilities.ScreenShotUtlities;

public class AccountsTest extends BaseTest {
	
	AccountsPage accTests;
	UserMenuPage userMenu;
	LoginPage login;
	
	WebDriver driver;
	PropertiesReader properties;
	ScreenShotUtlities screenshot = new ScreenShotUtlities();
	String username01,password01;
	
@BeforeMethod
	
	public void beforeMethod(){
		
		driver = launchBrowser();
		
		accTests = new AccountsPage(driver);
		
		accTests.userNameUserMenu();
		
	}

@Test(priority = 1)
		public void TC10() {
	
			accTests.goToAccTab();
			accTests.newBtnClick();
			accTests.createNewAccount();
	}

@Test(priority = 2)
		public void TC11() {



	}

@Test(priority = 3)
		public void TC12() {



	}

@Test(priority = 4)
		public void TC13() {



	}

@Test(priority = 5)
		public void TC14() {



	}






@AfterMethod

   public void teardown() {
	//screenshot.takeScreenShot(driver);
		closebrowser();
}


}
