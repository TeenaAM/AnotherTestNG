package com.testng.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtlities {
	
	public void takeScreenShot(WebDriver driver) {
		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		String filepath = "C:\\WorkSpace\\TestNGFrameWork\\screenshots\\screenshot01.jpeg";
		
		File desFile = new File(filepath);
		
		try {
			FileUtils.copyFile(srcFile, desFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
