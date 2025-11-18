package com.dlh.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimeSheetPage {
	
	private static TimeSheetPage timeSheetPage;
	
	private TimeSheetPage() {
		
	}
	
	public static TimeSheetPage getInstance() {
		if (timeSheetPage == null) {
			timeSheetPage = new TimeSheetPage();
		}
		return timeSheetPage;
	}

	@FindBy(xpath = "//input[contains(@placeholder,'Type for hints')]")
	private WebElement TIMESHEET;
	
	@FindBy(xpath = "//div[@role = 'listbox']")
	private WebElement selectValueFmDropdown;
	
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement SUBMIT;
	
	public void clickNameTextBox() {
		TIMESHEET.click();
	}
	
	public void enterTimesheet(String name) {
		TIMESHEET.sendKeys(name);
	}
	
	public void enterValue() {
		selectValueFmDropdown.click();
	}
	
	public void clickSubmit() {
		SUBMIT.click();
	}
}
