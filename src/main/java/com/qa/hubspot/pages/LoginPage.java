package com.qa.hubspot.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	private WebDriver driver;

	// By locators -- OR
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");

	
	
	// 2. create const.. of page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// 3. page actions
	@Step("get login page title...")
	public String getLoginPageTitle() {
		// return driver.getTitle();
		return elementUtil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}

	@Step("check sign up link on login page...")
	public boolean verifySignUpLink() {
		elementUtil.waitForElementToBeVisible(signUpLink, 10);
		return elementUtil.doIsDisplayed(signUpLink);
	}

	@Step("login to app with username: {0} and password: {1}")
	public HomePage doLogin(String username, String password) {
		elementUtil.waitForElementToBeVisible(this.username, 10);
		elementUtil.doSendKeys(this.username, username);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doClick(this.loginButton);

		
		return new HomePage(driver);
	}
}
