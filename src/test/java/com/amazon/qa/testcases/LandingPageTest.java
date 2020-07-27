package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LandingPage;
import com.amazon.qa.util.ScreenShotUtility;

import junit.framework.Assert;

public class LandingPageTest extends TestBase
{
	LandingPage landingPage;

	public LandingPageTest()
	{
		super();//To call the constructor of TestBase.java where we have written the file.properties
	}
	
	@BeforeMethod
	public void setUp()
	{
		intilization();//Call the test base initial Method
		landingPage=new LandingPage();//Create Object
	}
	@Test(priority=1)
	public void landingPageTitle(){
		
		String actualTitle=landingPage.validateLandingPageTitle();
		String expectedTitle="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		ScreenShotUtility.Screenshotlib(driver, "LandingPageTitle");
	}
	@Test(priority=2)
	
	public void clickonSignUp()
	{
		landingPage.SignIn();
		ScreenShotUtility.Screenshotlib(driver, "SignInPage");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
