package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//li[@menuitemname='Services']")
	WebElement servicesOptionLink;

	@FindBy(xpath = "//ul[@class='dropdown-menu show']/li[@menuitemname='My Services']")
	WebElement myServicesOptionLink;

	@FindBy(xpath = "//li[@menuitemname='Support']")
	WebElement supportOptionLink;

	@FindBy(xpath = "//h2[text()='Account Services']")
	WebElement AccountServicePage;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String toVerifyTitle() {
		return driver.getTitle();
	}

	public boolean toVerifyLoggedInUser() {
		return AccountServicePage.isDisplayed();
	}

	public MyServicePage clickOnServiceLink() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.click(servicesOptionLink).build().perform();
		Thread.sleep(5);
		// ac.moveToElement(myServicesOptionLink).click().perform();
		// servicesOptionLink.click();
		myServicesOptionLink.click();
		return new MyServicePage();

	}

}
