package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {

	private WebDriver driver;

	// 1. By locators--OR
	By header = By.cssSelector("h1.dashboard-selector__title");
	By accountMenu = By.id("account-menu-container");
	By accountName = By.cssSelector("a.navAccount-current > div.navAccount-accountName");

	// 2. constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page actions

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getHomePageHeader() {
		if (driver.findElement(header).isDisplayed()) {
			return driver.findElement(header).getText();
		}
		return null;
	}

	public String getLoggedInUser() {
		driver.findElement(accountMenu).click();
		if (driver.findElement(accountName).isDisplayed()) {
			return driver.findElement(accountName).getText().trim();
		}
		return null;
	}

}
