package com.dlh.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.dlh.utilities.CommonUtils;
import com.dlh.webdriver_manager.DriverManager;
import com.lao.constants.Constants;

import io.cucumber.java.Before;

public class Common_Step_Def {
    private static final Logger LOGGER = LogManager.getLogger(Common_Step_Def.class);
	
	@Before
	public void beforeScenario(){
		try {
			LOGGER.info("Starting beforeScenario setup...");
			CommonUtils commonUtils = new CommonUtils();
			commonUtils.loadProperties();
			LOGGER.info("Properties loaded successfully.");

			if(DriverManager.getDriver() == null) {
				LOGGER.info("Driver is null — launching browser...");
				DriverManager.launchBrowser();
				commonUtils.initElements();
			} else {
				LOGGER.info("Driver already initialized — skipping browser launch.");
			}

		} catch (Exception e) {
			LOGGER.info("Exception occurred in beforeScenario: " + e.getMessage());
			e.printStackTrace();
		} 
	}
	public void afterScenario() {
		LOGGER.info("Executing afterScenario...");
	}
}
