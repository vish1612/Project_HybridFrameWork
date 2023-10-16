package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR(Object Repository)
	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "loginBtn")
	WebElement loginBtn;

	@FindBy(xpath = "//i18n-string[text()='Sign up']")
	WebElement registerOption;

	@FindBy(id = "hs-login")
	WebElement loginPageOption;

	// To Initialize the PageFactory using initElements - Initializing Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions/Methods/Features

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateIsSignUpOptionDisplayed() {
		return registerOption.isDisplayed();
	}

	public boolean validateIsLoginOptionDisplayed() {
		return loginPageOption.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}

}
