package com.dlh.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dlh.utilities.CommonUtils;

public class DirectoryPage {
	
	private static DirectoryPage directoryPage;
	
	private DirectoryPage() {
		
	}
	
	public static DirectoryPage getInstance() {
		if (directoryPage == null) {
			directoryPage = new DirectoryPage();
		}
		return directoryPage;
	}
	
	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
	private WebElement JOBTITLEDROPDOWN;
	
	@FindBy(xpath = "//span[normalize-space(text())='Chief Financial Officer']")
	private  WebElement JOBTITLE;
	
	@FindBy(xpath = "//button[@type='submit']")
	private  WebElement SEARCHBUTTON;
	
	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/p[1]")
	private  WebElement FETCHNAME;
	
	public void clickJobTitleDropdown() {
		CommonUtils.getInstance().highlightWebElement(JOBTITLEDROPDOWN);
		JOBTITLEDROPDOWN.click();
	}
	
	public void selectJobTitle() {
		CommonUtils.getInstance().highlightWebElement(JOBTITLE);
		JOBTITLE.click();
	}
	
	public void clickSearchButton() {
		CommonUtils.getInstance().highlightWebElement(SEARCHBUTTON);
		SEARCHBUTTON.click();
	}
	
	public String fetchName() {
		CommonUtils.getInstance().highlightWebElement(FETCHNAME);
		return FETCHNAME.getText();
	}

	/*
	 * public WebElement getJOBTITLEDROPDOWN() { return JOBTITLEDROPDOWN; }
	 * 
	 * public WebElement getJOBTITLE() { return JOBTITLE; }
	 * 
	 * public WebElement getSEARCHBUTTON() { return SEARCHBUTTON; }
	 * 
	 * public WebElement getFETCHNAME() { return FETCHNAME; }
	 */
	
}
