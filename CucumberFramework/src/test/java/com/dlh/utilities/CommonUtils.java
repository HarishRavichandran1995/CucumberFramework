package com.dlh.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.dlh.pageobjects.DirectoryPage;
import com.dlh.pageobjects.HomePage;
import com.dlh.pageobjects.LoginPage;
import com.dlh.step_definitions.Common_Step_Def;
import com.dlh.webdriver_manager.DriverManager;
import com.lao.constants.Constants;

public class CommonUtils {
	
	private static CommonUtils commonUtils;
	private CommonUtils() {
		
	}
	
	public static CommonUtils getInstance() {
		if(commonUtils == null) {
			commonUtils = new CommonUtils();
		}
		return commonUtils;
	}
	
	public void loadProperties() {
		
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Constants.APP_URL = properties.getProperty("APP_URL");
		Constants.BROWSER =properties.getProperty("BROWSER");
		Constants.USERNAME =properties.getProperty("Username");
		Constants.PASSWORD =properties.getProperty("password");
		Constants.CHROME_DRIVER_LOCATION =properties.getProperty("CHROME_DRIVER_LOCATION");
		Constants.EDGE_DRIVER_LOCATION =properties.getProperty("EDGE_DRIVER_LOCATION");
	}
	
	public void initElements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getInstance());
	}
	
	public void takeScreenshot() {
		// TODO Auto-generated method stub
		File screenshot = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(Common_Step_Def.getScenarioName() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void highlightWebElement(WebElement element) {
		// TODO Auto-generated method stub
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].style.border='3px solid red'", element);
	}

}
