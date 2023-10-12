package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();	//This will call Base class Constructor to setup all Properties Files
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleValidate() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "ParaBank | Welcome | Online Banking","Title is not matched ith Expected");
	}
	
	@Test(priority=2)
	public void validateLoginPageDisplayed() {
		Boolean flag =loginpage.validateIsLoginPageDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
