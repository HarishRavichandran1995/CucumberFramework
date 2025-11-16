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

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[1]/div/div/div/div[2]/div/div/input")
	private WebElement TIMESHEET;
	
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement SUBMIT;
	
	public void clickNameTextBox() {
		TIMESHEET.click();
	}
	
	public void enterTimesheet(String name) {
		TIMESHEET.sendKeys(name);
	}
	
	public void clickSubmit() {
		SUBMIT.click();
	}
}
