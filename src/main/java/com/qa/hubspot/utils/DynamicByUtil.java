package com.qa.hubspot.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;

public class DynamicByUtil extends BasePage {



	public static By getDynamicXpathByLocator(String xpathStart,String xpathVal) {
		String resXpath=xpathStart+xpathVal+"']";		
		return By.xpath(resXpath);
	}
}
