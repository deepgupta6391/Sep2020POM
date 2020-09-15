package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(ExtentReportListener.class)
@Epic("Epic - 101: design login page with different features...")
@Story("US - 102: design basic login page with signup, title and login form...")
public class LoginPageTest extends BaseTest {

	@Test(priority = 2)
	@Description("verify Login Page Title Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitle() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page title is not matched...");
		//throw new SkipException("Skipping this to test");
	}

	@Test(priority = 1)
	@Description("verify sign up link test...")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySignupLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(), "sign up link is not displayed...");

	}

	@Test(priority = 3)
	@Description("verify Login Test...")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		HomePage homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePage.getHomePageHeader(), Constants.HOME_PAGE_HEADER);
	}

}
