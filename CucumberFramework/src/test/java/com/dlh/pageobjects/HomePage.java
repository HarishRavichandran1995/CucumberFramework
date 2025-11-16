package com.dlh.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dlh.utilities.CommonUtils;

public class HomePage {
	
	private static HomePage homePage;
	
	private HomePage() {
		
	}
	
	public static HomePage getInstance() {
		if (homePage == null) {
			homePage = new HomePage();
		}
		return homePage;
	}
	
	@FindBy(linkText = "Directory")
	private WebElement DIRECTORY;
	
	@FindBy(linkText = "Time")
	private WebElement TIMESHEET;
	
	
	
	public void clickDirectory() {
		CommonUtils.getInstance().highlightWebElement(DIRECTORY);
		DIRECTORY.click();
	}
	
	public void clickTimesheet() {
		CommonUtils.getInstance().highlightWebElement(TIMESHEET);
		TIMESHEET.click();
	}

	/*
	 * public WebElement getDIRECTORY() { return DIRECTORY; }
	 */
}
