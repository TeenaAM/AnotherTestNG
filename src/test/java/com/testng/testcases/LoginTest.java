package com.testng.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.pages.LoginPage;
import com.testng.utilities.PropertiesReader;
import com.testng.utilities.ScreenShotUtlities;

 

public class LoginTest extends BaseTest {
	
	LoginPage login;
	WebDriver driver;
	PropertiesReader properties;
	ScreenShotUtlities screenshot = new ScreenShotUtlities();
	
	
	@BeforeMethod
	
	public void beforeMethod(){
		
		driver = launchBrowser();
		login = new LoginPage(driver);
		
	}
	
	@Test(priority=1)
	public void logInNoPassword(){
	
		login.EnterUserNameValid("Teena12@testingtrials.com");
		login.NoPassword();
		
		login.ClickLoginBtn();
	
	}
	
	@Test(priority=2)
		public void loginValidUserName(){
		
		login.EnterUserNameValid("Teena@testingtrials.com");
		login.EnterPasswordValid("pswrd@2024");
		login.ClickLoginBtn();
		
		
	}
	
	@Test(priority=3)
	public void remeberMeCheckBox() throws InterruptedException{
	
		login.EnterUserNameValid("Teena@testingtrials.com");
		login.EnterPasswordValid("pswrd@2024");
		
		login.remMeChkBx();
		
		login.ClickLoginBtn();
	
		login.UserNameDropDown();
		
		login.LogOutSelect();
		
}
	@Test(priority=4)
	public void forgotPassword4a() {
		
		login.EnterUserNameValid("Teena@testingtrials.com");
		login.ForgotPasswordLink();
		
		String actualFrgtPswrdMsg = driver.findElement(By.xpath("//h1[@id='header']")).getText();
		String expectedFrgtPswrdMsg = "Forgot Your Password";
		Assert.assertEquals(actualFrgtPswrdMsg, expectedFrgtPswrdMsg);
		
		
	}
	
	@Test(priority=5)
	public void forgotPassword4b() {

		login.EnterUserNameValid("1234");
		login.EnterPasswordValid("22131");
		login.ClickLoginBtn();
		
		login.validateTC04();
		
	}

	
	@AfterMethod
	
	public void teardown() {
		screenshot.takeScreenShot(driver);
		closebrowser();
	}

}
