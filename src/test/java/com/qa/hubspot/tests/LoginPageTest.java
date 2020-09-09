package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest {
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	Properties prop;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 2)
	public void verifyLoginPageTitle() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page title is not matched...");
	}

	@Test(priority = 1)
	public void verifySignupLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(), "sign up link is not displayed...");
	}

	@Test(priority = 3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		// Assert.assertEquals(actual, expected);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
