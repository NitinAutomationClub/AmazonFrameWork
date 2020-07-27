package com.amazon.qa.util;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	
	public static  void  Screenshotlib(WebDriver driver,String screenshotName )
	{
		try {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("./ScreenShot/"+screenshotName+ ".jpeg"));
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}	
	}
	

}
