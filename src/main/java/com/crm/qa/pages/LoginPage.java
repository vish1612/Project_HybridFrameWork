package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR(Object Repository)
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(linkText = "Register")
	WebElement signUpLink;

	@FindBy(xpath = "//img[@title='ParaBank']")
	WebElement companyLogo;

	@FindBy(xpath = "//div[@id='loginPanel']")
	WebElement loginPageLogo;

	// To Initialize the PageFactory using initElements - Initializing Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions/Methods/Features

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateIsLoginPageDisplayed() {
		return loginPageLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}

}
