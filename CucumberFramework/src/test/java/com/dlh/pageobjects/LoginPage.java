package com.dlh.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	public WebElement getUSERNAME() {
		return USERNAME;
	}
	public WebElement getPASSWORD() {
		return PASSWORD;
	}
	public WebElement getSUBMIT() {
		return SUBMIT;
	}
}
