package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;

	// 1. By locators--OR
	By header = By.cssSelector("h1.dashboard-selector__title");

	By accountMenu = By.id("account-menu-container");
	By accountName = By.cssSelector("a.navAccount-current > div.navAccount-accountName");

	By primaryContactLink = By.id("nav-primary-contacts-branch");
	By secondaryContactLink = By.id("nav-secondary-contacts");

	// 2. constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// 3. Page actions
	public String getHomePageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
	}

	public String getHomePageHeader() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	public String getLoggedInUser() {
		elementUtil.doClick(accountMenu);
		if (elementUtil.doIsDisplayed(accountName)) {
			return elementUtil.doGetText(accountName);
		}
		return null;
	}
	
	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	private void clickOnContacts() {
		elementUtil.waitForElementToBeVisible(primaryContactLink, 30);
		elementUtil.doClick(primaryContactLink);
		elementUtil.waitForElementToBeVisible(secondaryContactLink, 10);
		elementUtil.doClick(secondaryContactLink);
	}
}
