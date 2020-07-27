package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LandingPage extends TestBase
{
@FindBy(xpath="//div[@id='nav-logo']") WebElement logo;
@FindBy(xpath="//span[@class='nav-line-2 ']//span[@class='nav-icon nav-arrow']") WebElement arrow;

public LandingPage()
{
	PageFactory.initElements(driver, this);
}

public String validateLandingPageTitle()
{
	return driver.getTitle();
}

public LoginPage SignIn()
{
	arrow.click();
	return new LoginPage();
}
}
