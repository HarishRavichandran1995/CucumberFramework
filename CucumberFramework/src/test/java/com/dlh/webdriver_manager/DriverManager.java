package com.dlh.webdriver_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.dlh.step_definitions.Common_Step_Def;
import com.lao.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private static WebDriver driver = null;
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
	
	public static void launchBrowser() {
		try { 
			LOGGER.info("Launching browser: " + Constants.BROWSER);
			switch (Constants.BROWSER) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				LOGGER.info("Chrome browser launched successfully.");
				break;
				
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				LOGGER.info("Edge browser launched successfully.");
				break;

			default:
				LOGGER.info("Unknown browser specified. Defaulting to Chrome.");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				LOGGER.info("Default Chrome browser launched successfully.");
				break;
			}
		} catch (Exception e) {
			LOGGER.info("Exception occurred while launching browser: " + e.getMessage());
			e.printStackTrace();
		}	
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
