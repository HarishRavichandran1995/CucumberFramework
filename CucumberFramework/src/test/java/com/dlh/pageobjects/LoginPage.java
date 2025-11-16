package com.dlh.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dlh.utilities.CommonUtils;

public class LoginPage {
	
	private static LoginPage loginPage;
	
	private LoginPage() {
		
	}
	
	public static LoginPage getInstance() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}
	
	
	@FindBy(name = "username")
	private  WebElement USERNAME;
	@FindBy(name = "password")
	private  WebElement PASSWORD;
	@FindBy(xpath = "//button[@type='submit']" )
	private  WebElement SUBMIT;
	
	public void enterUserName(String username) {
		CommonUtils.getInstance().highlightWebElement(USERNAME);
		USERNAME.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		CommonUtils.getInstance().highlightWebElement(PASSWORD);
		PASSWORD.sendKeys(password);
	}
	
	public void clickSubmit() {
		CommonUtils.getInstance().highlightWebElement(SUBMIT);
		SUBMIT.click();
	}
	
	
	
	/*
	 * public WebElement getUSERNAME() { return USERNAME; } public WebElement
	 * getPASSWORD() { return PASSWORD; } public WebElement getSUBMIT() { return
	 * SUBMIT; }
	 */
}
