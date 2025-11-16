package com.dlh.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewTimeSheetPage {
	
	private static ViewTimeSheetPage viewTimeSheet;
	
	private ViewTimeSheetPage() {
		
	}
	
	public static ViewTimeSheetPage getInstance() {
		if (viewTimeSheet == null) {
			viewTimeSheet = new ViewTimeSheetPage();
		}
		return viewTimeSheet;
	}
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[2]/div/div[1]/p")
	private WebElement TIMESHEETPERIOD;
	
	public String getTimeSheetPeriod() {
		return TIMESHEETPERIOD.getText();
	}
}
