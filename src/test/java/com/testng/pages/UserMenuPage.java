package com.testng.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.testng.base.BasePage;
import com.testng.utilities.PropertiesReader;
import com.testng.utilities.ScreenShotUtlities;

public class UserMenuPage extends BasePage {
	
	static WebDriver driver;
		
	public UserMenuPage(WebDriver driver) {
		super(driver);
		
	}

	//LoginPage login;
	//WebDriver driver;
	PropertiesReader properties;
	ScreenShotUtlities screenshot = new ScreenShotUtlities();
	String username02,password02, usrnmTC07, emIDTC07, parentWindowHandle01, childWindowHandle01;
	
	//UserMenuPage userMenu;
	
	 @FindBy(id="username")
	 WebElement userNameMenu;
	 
	 @FindBy(id="password")
	 WebElement passwordMenu;
	 
	 @FindBy(id="Login")
	 WebElement loginBtnMenu; 
	
	 @FindBy(id ="userNav")
	 WebElement userNameDrpDwn;
	 
	 @FindBy(xpath = "//a[@title='My Settings']")
	 WebElement mySettingsClick;
	 
	 @FindBy(xpath = "//span[@id='PersonalInfo_font']")
	 WebElement persnalInfoSelect;
	 
	 @FindBy(xpath="//*[@id=\"LoginHistory_font\"]")
	 WebElement loginHistoryLink;
	 
	 @FindBy(xpath="//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	 WebElement downloadLinkLoginHistory;
	 
	 @FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	 WebElement displayLayLink;
	 
	 @FindBy(xpath="//*[@id=\"CustomizeTabs_font\"]")
	 WebElement customMyTabsLink;
	 
	 @FindBy(xpath="//*[@id=\"p4\"]")
	 WebElement customerAppDrpdown;
	 
	 @FindBy(xpath="//*[@id=\"duel_select_0\"]/option[86]")
	 WebElement toAddReportsTab;
	 
	 @FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	 WebElement addArrowBtn;
	 
	 @FindBy(xpath ="//*[@id=\"bottomButtonRow\"]/input[1]" )
	 WebElement saveTabbsBtn;
	 
	 @FindBy(xpath = "//*[@id=\"EmailSetup_font\"]" )
	 WebElement emailLinkclick;
	 
	 @FindBy(xpath = "//*[@id=\"EmailSettings_font\"]")
	 WebElement emailSettingsAlt;
	 
	 @FindBy(xpath = "//input[@id='sender_name']")
	 WebElement alterEmailName;
	 
	 @FindBy(xpath = "//*[@id=\"sender_email\"]")
	 WebElement alterEmailId;
	 
	 @FindBy(xpath = "//*[@id=\"auto_bcc1\"]")
	 WebElement AutoBccRadioBtn;
	 
	 @FindBy(xpath="//*[@id=\"bottomButtonRow\"]/input[1]")
	 WebElement saveEmSettings;
	 
	 @FindBy(id = "CalendarAndReminders_font")
	 WebElement calenderReminder;
	 
	 @FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	 WebElement actReminders;
	 
	 @FindBy(xpath ="//*[@id=\"testbtn\"]" )
	 WebElement remTesting;
	 
	 @FindBy(linkText = "Developer Console")
	 WebElement devConsoleOpt;
	 
	 @FindBy(xpath= "//*[@id=\"userNav-menuItems\"]/a[5]")
	 WebElement logOutSel;
	 
	 public void userNameUserMenu() {
		 
			properties = new PropertiesReader();
			
			userNameMenu.clear();
			username02 = properties.getProperty("username");
			userNameMenu.sendKeys(username02);
			
			password02 = properties.getProperty("password");
			passwordMenu.sendKeys(password02);
			
			loginBtnMenu.click();
			
			
		 
	 }
	 
	 
	 public void UserNameDropDown() {
		
		provisionForWaitToClick(userNameDrpDwn, By.id("userNav"));
		
		userNameDrpDwn.click();
		
	}
	 
	 public void validateTC05() {
		 // this is not working
		 List<String> menuDropDownItems = new ArrayList<String>(Arrays.asList("My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"));
		 List<WebElement> whatWeSee = driver.findElements(By.cssSelector("div#userNav-menuItems a"));
		 System.out.println(whatWeSee);
		 List<String> whatWeSeeList = new ArrayList<String>();
		 
		 for(WebElement check: whatWeSee) {
			 System.out.println(check.getText());
			 whatWeSeeList.add(check.getText());
		  }
		 
		 Assert.assertEquals(whatWeSeeList, menuDropDownItems, "Menu Drop Down is Wrong");
	 }
	 
	 public void MySettingsClick() {
		 
		 mySettingsClick.click();
		 		 		 
	 }
	 
	 public void personalLinkSel() {
		 
		 persnalInfoSelect.click();
	 }

	 public void loginHistoryLinkSel() {
		 
		 loginHistoryLink.click();
	 }
	 
	 public void downldLoginHistoryLink() {
		 
		 downloadLinkLoginHistory.click();
	 }

	 public void displayLayoutClick() {
		 
		 displayLayLink.click();  
	 }
	 
	 public void customMyTabsLink() {
		 
		 customMyTabsLink.click();
	 }
	 
	 public void removeTabsTest() {
		 
		 customerAppDrpdown.click();
		 
		 Select selSFChatter = new Select(customerAppDrpdown);
		 selSFChatter.selectByValue("02uaj000008t0w2");
		 
		 toAddReportsTab.click();
		 
		 addArrowBtn.click();
		 
		 saveTabbsBtn.click();
	 }
	 
	 public void alterEmailSettings() {
		 
		 emailLinkclick.click();
		 emailSettingsAlt.click();
		 
		 usrnmTC07 = properties.getProperty("usernameTC07");
		 alterEmailName.clear();
		 alterEmailName.sendKeys(usrnmTC07);
		 
		 emIDTC07 = properties.getProperty("emailIdTC07");
		 alterEmailId.clear();
		 alterEmailId.sendKeys(emIDTC07);
		 
		 if(!AutoBccRadioBtn.isSelected()) {
		 AutoBccRadioBtn.click();
		 }
		 
		 saveEmSettings.click();
		 
	 }
	 
	 public void testActivityReminder() throws InterruptedException {
		 
		 calenderReminder.click();
		 actReminders.click();
		 remTesting.click();
		 //the main browser closes but the reminder test window remains open
		 Thread.sleep(2000);
		 
	 }
	 
	 public void DevConClick() {
		 
		 devConsoleOpt.click();
		 //Thread.sleep(5000);
	 }
	 
	 public void DevConOperations() {
		 
	
		 //null pointer exception in the next line
		    //parentWindowHandle01 = driver.getWindowHandle();
		    //Thread.sleep(2000);			
		    
		    //System.out.println("Parent Handle: " + parentWindowHandle01);
			
			Set<String> handles = driver.getWindowHandles();
				//System.out.println(handles);
			Iterator<String> it = windows.iterator();
			String parentWindowHandle01 = it.next();
			String childWindowHandle01 = it.next();
			System.out.println("Parent Window: "+ parentWindowHandle01);
			System.out.println("Child Window: "+ childWindowHandle01);
				driver.switchTo().window(childWindowHandle01);
				
			
			
			//System.out.println("After Switching: " +driver.getTitle());
			//Thread.sleep(5000);
			
			driver.close();
			driver.switchTo().window(parentWindowHandle01);
			
			//parentWindowHandle01 = driver.getWindowHandle();
			//System.out.println("Back to the Parent:" + parentWindowHandle01);
			//System.out.println("Back to Parent Title:" + driver.getTitle());
	 }
	 
	 public void logOutSelect() {
		 
		 logOutSel.click();
		 
	 }
}
