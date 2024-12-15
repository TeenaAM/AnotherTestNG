package com.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.testng.base.BasePage;
import com.testng.utilities.PropertiesReader;
import com.testng.utilities.ScreenShotUtlities;

public class AccountsPage extends BasePage {
	
	static WebDriver driver;
	
	public AccountsPage(WebDriver driver) {
		super(driver);
		
	}

	//LoginPage login;
	//WebDriver driver;
	
	PropertiesReader properties01, properties02;
	ScreenShotUtlities screenshot = new ScreenShotUtlities();
	String username03,password03, newAccName01;
	
	@FindBy(id="username")
	 WebElement userNameMenu;
	 
	 @FindBy(id="password")
	 WebElement passwordMenu;
	 
	 @FindBy(id="Login")
	 WebElement loginBtnMenu; 
	
	 @FindBy(id ="userNav")
	 WebElement userNameDrpDwn;
	
	 @FindBy(id="Account_Tab")
	 WebElement accTab;
	 
	 @FindBy(xpath = "//input[@value = ' New ']")
	 WebElement newBtn;
	 
	 @FindBy(xpath = "//input[@id = 'acc2']")
	 WebElement newAccName;
	 
	 @FindBy(xpath="//select[@id = 'acc6']")
	 WebElement typeDrpDwn;
	 
	 @FindBy(xpath="//*[@id=\"acc6\"]/option[7]")
	 WebElement techPartner;
	 
	 @FindBy(xpath="//*[@id=\"00Naj000006YSeM\"]")
	 WebElement custPriority;
	 
	 @FindBy(xpath="//*[@id=\"00Naj000006YSeM\"]/option[2]")
	 WebElement highPriority;
	 
	 @FindBy(xpath="//*[@id=\"topButtonRow\"]/input[1]")
	 WebElement saveBtn;

	public void userNameUserMenu() {
		
		properties01 = new PropertiesReader();
		
		userNameMenu.clear();
		username03 = properties01.getProperty("username");
		userNameMenu.sendKeys(username03);
		
		password03 = properties01.getProperty("password");
		passwordMenu.sendKeys(password03);
		
		loginBtnMenu.click();
		
			
		
	}
	
	public void goToAccTab() {
		
		accTab.click();
		
	}
	
	public void newBtnClick() {
		
		newBtn.click();
		
	}
	
	public void createNewAccount() {
		
		properties02 = new PropertiesReader();
		
		newAccName.clear();
		newAccName01 = properties02.getProperty("accTrials01");
		newAccName.sendKeys(newAccName01);
		//Thread.sleep(2000);
		
		typeDrpDwn.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(typeDrpDwn).build().perform();
		
		techPartner.click();
		//Thread.sleep(2000);
		
		custPriority.click();
		
		Actions actionsPri = new Actions(driver);
		actionsPri.moveToElement(custPriority).build().perform();
		
		highPriority.click();
		
		saveBtn.click();
		//Thread.sleep(2000);
		
		
	}
	 

}
