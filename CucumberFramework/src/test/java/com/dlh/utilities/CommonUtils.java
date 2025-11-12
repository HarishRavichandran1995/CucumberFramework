package com.dlh.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.dlh.pageobjects.DirectoryPage;
import com.dlh.pageobjects.HomePage;
import com.dlh.pageobjects.LoginPage;
import com.dlh.webdriver_manager.DriverManager;
import com.lao.constants.Constants;

public class CommonUtils {
	
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

}
