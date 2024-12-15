package com.testng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.testng.base.BasePage;

public class LoginPage extends BasePage {
	
	 static WebDriver driver;
	 
	 @FindBy(id="username")
	 WebElement userName;
	 
	 @FindBy(id="password")
	 WebElement password;
	 
	 @FindBy(id="Login")
	 WebElement loginBtn; 
	 
	 @FindBy(id="rememberUn")
	 WebElement remMeCheckBox;
	 
	 @FindBy(id ="userNav")
	 WebElement userNameDrpDwn;
	 
	 @FindBy(id="forgot_password_link")
	 WebElement forgotPswrdLink;
	 
	 @FindBy(xpath="//a[@title='Logout']")
	 WebElement logOutOption;
	 
	 @FindBy(xpath="//div[@id = 'error']")
	 WebElement stractualErrorMsg;
	
	public LoginPage(WebDriver driver) {
		
		super (driver);//calling the parameterized constructor of the parent class is why we are using Super
	}

	public void EnterUserNameValid(String validUsername) {
		
		userName.clear();
		userName.sendKeys(validUsername);
		
		
	}
		
	public void EnterPasswordValid(String validPassword) {
		
		password.sendKeys(validPassword);
		
	}
	
		
	public void ClickLoginBtn() {
		provisionForWait(loginBtn);
		loginBtn.click();
	}

	public void NoPassword() {

		password.clear();
		
	}

	public void remMeChkBx() {
		
		remMeCheckBox.click();
			
	}

	public void UserNameDropDown() {
		
		provisionForWaitToClick(userNameDrpDwn, By.id("userNav"));
		userNameDrpDwn.click();
		
	}


	public void LogOutSelect() {
		
		provisionForWait(logOutOption);
		logOutOption.click();
		
	}
	
	public void ForgotPasswordLink() {
		
		provisionForWait(forgotPswrdLink);
		forgotPswrdLink.click();
		
	}
	
	public void validateTC04() {
		
		 String actualErrorMsg = stractualErrorMsg.getText();
		 
		 String expectedErrorMsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		 Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		
	}

}
