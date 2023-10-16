package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//a[@data-test-id='home-link']")
	WebElement homPageDisplay;

	@FindBy(xpath = "//a[@role='menuitem' and contains(text(),'Service')]")
	WebElement serviceOptionLink;

	@FindBy(xpath = "//a[@role='menuitem' and contains(text(),'Contact')]")
	WebElement contactOptionLink;

	@FindBy(xpath = "//a[@role='menuitem']//div[contains(text(),'Contacts')]")
	WebElement clickContactOption;
	
	@FindBy(xpath = "//li[@menuitemname='Support']")
	WebElement supportOptionLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String toVerifyTitle() {
		return driver.getTitle();
	}
	
	public boolean isHomePageDisplayed() {
		return homPageDisplay.isDisplayed();
	}
	
	public boolean isServiceLinkDisplayed() {
		return serviceOptionLink.isDisplayed();
	}
	
	public ContactPage clickOnContactOption() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.clickAndHold(contactOptionLink).build().perform();
		clickContactOption.click();
		// ac.moveToElement(myServicesOptionLink).click().perform();
		// servicesOptionLink.click();
		//myServicesOptionLink.click();
		return new ContactPage();

	}

}
