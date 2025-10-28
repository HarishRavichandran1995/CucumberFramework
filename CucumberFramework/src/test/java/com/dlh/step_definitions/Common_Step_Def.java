package com.dlh.step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.Before;

public class Common_Step_Def {
	
	public static WebDriver driver;
	
	@Before
	public void beforeScenario() {
		try {
			if(driver==null) {
			launchBrowser();} 
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void launchBrowser() {
		try {
			switch ("browserChosen") {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", 
				        "C:\\Users\\haris\\Downloads\\driver1\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
				
			case "edge":
				System.setProperty("webdriver.edge.driver", 
				        "C:\\Users\\haris\\Downloads\\driver1\\msedgedriver.exe");
				driver = new EdgeDriver();
				break;

			default:
				System.setProperty("webdriver.chrome.driver", 
				        "C:\\Users\\haris\\Downloads\\driver1\\chromedriver.exe");
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
