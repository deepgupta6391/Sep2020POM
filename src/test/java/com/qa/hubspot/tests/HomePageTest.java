package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest {

	HomePage homePage;

	@BeforeClass
	public void homeSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 3)
	public void verifyPageTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "home page title is not matched...");
	}

	@Test(priority = 1)
	public void verifyHomePageHeader() {
		String header = homePage.getHomePageHeader();
		System.out.println("Home page header is : " + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "home page header is not matched...");
	}

	@Test(priority = 2)
	public void verifyLoggedInUserTest() {
		String loggedInUser = homePage.getLoggedInUser();
		System.out.println("Logged in user is : " + loggedInUser);
		Assert.assertEquals(loggedInUser, prop.getProperty("accountname"));
	}
}
