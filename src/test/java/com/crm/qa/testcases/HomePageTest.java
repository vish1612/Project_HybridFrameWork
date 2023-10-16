package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;

	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	/*
	 * @Test(priority = 1) public void toVerifyTitleofHomePage() { String title =
	 * homepage.toVerifyTitle(); Assert.assertEquals(title,
	 * "Knowledgebase - PHPTRAVELS", "Title of page is Mismatched"); }
	 * 
	 * @Test(priority = 2) public void toVerifyUserIsDisplayed() {
	 * assertTrue(homepage.toVerifyLoggedInUser()); }
	 */
	

	@Test(priority = 1)
	public void createNewContactOption() throws InterruptedException {
		contactpage = homepage.clickOnContactOption();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
