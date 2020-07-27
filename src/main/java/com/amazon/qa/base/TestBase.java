package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	//Create Constructor for File Reading

	public TestBase()
	{
		
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
			prop.load(fis);
		}
		 catch (IOException e) 
		{
		e.printStackTrace();
		}
				
	}
	
	public static void intilization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./drivers\\chromedriver.exe");
			driver =new ChromeDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./drivers\\geckodriver.exe");
			driver =new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
	}

}