package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.ScreenShotUtility;

public class LoginPage extends TestBase
{

	//Define Page Factory or Object Rrpository
	@FindBy(name="email") WebElement userName;
	@FindBy(xpath="//input[@id='continue']") WebElement continueBtn;
	@FindBy(xpath="//i[@class='a-icon a-icon-logo']") WebElement logo;
	@FindBy(name="password") WebElement pswrd;
	@FindBy(xpath="//input[@id='signInSubmit']") WebElement signInbtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginTitle()
	{
	return driver.getTitle();
	}
	
	public HomePage login(String un , String pswd) throws InterruptedException
	{
		userName.sendKeys(un);
		ScreenShotUtility.Screenshotlib(driver, "UserName");
		continueBtn.click();
		System.out.println("Entered User Name");
		Thread.sleep(5000);
	
		pswrd.sendKeys(pswd);
		System.out.println("Entered Password");
		
		ScreenShotUtility.Screenshotlib(driver, "PassWord");
		signInbtn.click();
		
		return new HomePage();
	}
	
	
	
	
}
