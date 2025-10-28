package com.dlh.step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.dlh.utilities.CommonUtils;
import com.lao.constants.Constants;

import io.cucumber.java.Before;

public class Common_Step_Def {
	
	public static WebDriver driver;
	
	@Before
	public void beforeScenario() {
		try {
			CommonUtils.loadProperties();
			if(driver==null) {
			launchBrowser();} 
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void launchBrowser() {
		try {
			switch (Constants.BROWSER) {
			case "chrome":
				System.setProperty(Constants.CHROME_DRIVER, Constants.CHROME_DRIVER_LOCATION);
				driver = new ChromeDriver();
				break;
				
			case "edge":
				System.setProperty(Constants.EDGE_DRIVER,Constants.EDGE_DRIVER_LOCATION);
				driver = new EdgeDriver();
				break;

			default:
				System.setProperty(Constants.CHROME_DRIVER, Constants.CHROME_DRIVER_LOCATION);
				driver = new ChromeDriver();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void afterScenario() {
		
	}

}
