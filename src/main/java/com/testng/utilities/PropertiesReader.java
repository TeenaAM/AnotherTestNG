package com.testng.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	FileInputStream fileInput;
	
	public String getProperty(String key) {
	
		String filePath = "C:\\WorkSpace\\TestNGFrameWork\\Properties\\applications.properties";
			try {
				fileInput = new FileInputStream(filePath);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		Properties prop = new Properties();
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		String value = prop.getProperty(key);
		System.out.println(value);
		return value;

	
	 }
}