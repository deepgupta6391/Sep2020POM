package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.DynamicByUtil;
import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.JavaScriptUtil;

public class ContactsPage extends BasePage {

	private WebDriver driver;

	By header = By.cssSelector("h1.IndexPageRedesignHeader__StyledH1-ljkrr-1.dTXiYC > span");
	By createContactPrimary = By.xpath("(//span[text()='Create contact'])[position()=1]");
	String emailXpathStart = "//a[text()='";
	By emailToValidate;

	// *******************Locators of create account form*************************
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By createContactSecondary = By.xpath("(//span[text()='Create contact'])[last()]");

	// ***********Locators of account created confirmation*************************
	By contactsBackLink = By.xpath("(//i18n-string[text()='Contacts'])[last()]");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	public String getContactsPageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.CONTACTS_PAGE_TITLE, 10);
	}

	public String getContactsPageHeader() {
		elementUtil.waitForElementToBeVisible(header, 10);
		return elementUtil.doGetText(header);
	}

	public void createContact(String email, String firstName, String lastName, String jobTitle) {
		elementUtil.clickWhenReady(createContactPrimary, 10);

		elementUtil.waitForElementToBeVisible(this.email, 10);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);

		elementUtil.waitForElementToBeVisible(this.jobTitle, 5);
		elementUtil.doSendKeys(this.jobTitle, jobTitle);

		// elementUtil.clickWhenReady(createContactSecondary, 5);
		elementUtil.waitForElementToBeClickable(createContactSecondary, 10);
		elementUtil.doActionsClick(createContactSecondary);

		elementUtil.waitForElementToBeVisible(contactsBackLink, 10);
		elementUtil.doClick(contactsBackLink);

	}

	public String getEmailForValidation(String emailVal) {
		emailToValidate = DynamicByUtil.getDynamicXpathByLocator(emailXpathStart, emailVal);
		jsUtil.refreshBrowserByJS();
		jsUtil.checkPageIsReady();
		elementUtil.waitForElementToBeVisible(emailToValidate, 15);
		return elementUtil.doGetText(emailToValidate);
	}

}
