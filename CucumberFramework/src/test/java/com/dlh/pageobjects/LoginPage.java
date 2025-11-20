package com.dlh.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dlh.utilities.CommonUtils;
import com.dlh.webdriver_manager.DriverManager;

public class LoginPage {
	
	private static LoginPage loginPage;
	
	WebDriver driver =   DriverManager.getDriver();
	
	private LoginPage() {
		
	}
	
	public static LoginPage getInstance() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}
	
	By USERNAME = By.name("username");
	By PASSWORD = By.name("password");
	By SUBMIT = By.xpath("//button[@type='submit']");
	
	/*
	 * @FindBy(name = "username") private WebElement USERNAME;
	 * 
	 * @FindBy(name = "password") private WebElement PASSWORD;
	 * 
	 * @FindBy(xpath = "//button[@type='submit']" ) private WebElement SUBMIT;
	 */
	
	public void enterUserName(String username) {
	    try {
	    	Thread.sleep(2000);
	    	CommonUtils.getInstance().highlightWebElement(driver.findElement(USERNAME));
	        //CommonUtils.getInstance().highlightWebElement(USERNAME);
	        DriverManager.getDriver().findElement(USERNAME).sendKeys(username);
	    	//USERNAME.sendKeys(username);
	    } catch (Exception e) {
	        System.out.println("❌ Failed to enter username: " + e.getMessage());   
	        try {
	        	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
	        	wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME));

			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("❌ Retry failed: " + e2.getMessage());
			}
	    }
	}

	public void enterPassword(String password) {
	    try {
	    	CommonUtils.getInstance().highlightWebElement(driver.findElement(PASSWORD));
	        //CommonUtils.getInstance().highlightWebElement(PASSWORD);
	        DriverManager.getDriver().findElement(PASSWORD).sendKeys(password);
	    	//PASSWORD.sendKeys(password);
	    } catch (Exception e) {
	        System.out.println("❌ Failed to enter password: " + e.getMessage());
	        try {
	        	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
	        	wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD));

			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("❌ Retry failed: " + e2.getMessage());
			}
	    }
	}

	public void clickSubmit() {
	    try {
	    	CommonUtils.getInstance().highlightWebElement(driver.findElement(SUBMIT));
	        //CommonUtils.getInstance().highlightWebElement(SUBMIT);
	    	DriverManager.getDriver().findElement(SUBMIT).click();
	        //SUBMIT.click();
	    } catch (Exception e) {
	        System.out.println("❌ Failed to click Submit button: " + e.getMessage());
	        try {
	        	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
	        	wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD));

			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("❌ Retry failed: " + e2.getMessage());
			}
	    }
	}

	
	
	
	/*
	 * public WebElement getUSERNAME() { return USERNAME; } public WebElement
	 * getPASSWORD() { return PASSWORD; } public WebElement getSUBMIT() { return
	 * SUBMIT; }
	 */
}
