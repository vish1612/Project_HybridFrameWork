package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MyServicePage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	MyServicePage servicepage;

	String sheetName = "contacts";
	
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
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 3)
	public void clickOnMyService() throws InterruptedException {
		servicepage = homepage.clickOnServiceLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
