package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LandingPage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.util.ScreenShotUtility;

public class LoginPageTest extends TestBase
{
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod()
	public void setUp()
	{
		intilization();
	//	landingPage=new LandingPage();//Create Object
		loginPage =new LoginPage();
		LandingPage landingPage=new LandingPage();
		landingPage.SignIn();
	}
	@Test(priority=1)
	public void loginTitle()
	{
		String actualTitle=loginPage.validateLoginTitle();
		String expectedTitle="Amazon Sign-In";
		Assert.assertEquals(actualTitle, expectedTitle);
		ScreenShotUtility.Screenshotlib(driver, "LoginPageTitle");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException
	{
		homePage=loginPage.login(prop.getProperty("usName"), prop.getProperty("password"));
		
		
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
