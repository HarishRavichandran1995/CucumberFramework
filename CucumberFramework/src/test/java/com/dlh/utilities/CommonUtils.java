package com.dlh.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.lao.constants.Constants;

public class CommonUtils {
	
	public static void loadProperties() {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties properties = new Properties();
		try {
			properties.load(fileReader);
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

}
