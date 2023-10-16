package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	String expTitle = "HubSpot Login";
	String sheetName = "logincredentials";

	public LoginPageTest() {
		super(); // This will call Base class Constructor to setup all Properties Files
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}

	
	  @Test(priority = 1) public void loginPageTitleValidate() { String actTitle =
	  loginpage.validateLoginPageTitle(); Assert.assertEquals(actTitle, expTitle);
	  }
	  
	  @Test(priority = 2) public void validateLoginPageDisplayed() { Boolean flag =
	  loginpage.validateIsLoginOptionDisplayed(); Assert.assertTrue(flag); }
	  
	  @Test(priority = 3) public void validateSignUpOptionDisplayed() { Boolean
	  flag = loginpage.validateIsSignUpOptionDisplayed(); Assert.assertTrue(flag);
	  }
	  
	  @Test(priority = 4) public void loginTest() { homepage =
	  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	  }
	 
	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 5, dataProvider = "getLoginTestData")
	public void loginTestwithOtherCredentials(String userName, String passWord) {
		loginpage.login(userName, passWord);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
