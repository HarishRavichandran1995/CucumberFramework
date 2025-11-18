package com.dlh.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dlh.pageobjects.HomePage;
import com.dlh.pageobjects.LoginPage;
import com.dlh.pageobjects.TimeSheetPage;
import com.dlh.pageobjects.ViewTimeSheetPage;
import com.dlh.utilities.CommonUtils;
import com.dlh.webdriver_manager.DriverManager;
import com.lao.constants.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyPendingTimeSheets_Step_Def {
	
	private static final Logger LOGGER = LogManager.getLogger(VerifyPendingTimeSheets_Step_Def.class);
	
	@Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        // TODO: Write code to ensure user is on homepage
		try {
			String url = DriverManager.getDriver().getCurrentUrl();
			if(url.contains("dashboard")) {
				LOGGER.info("User is logged on successfully and is on Home Page");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			CommonUtils.getInstance().takeScreenshot();
			LOGGER.error("Error while logging in: " + e.getMessage());
		}
    }

    @When("the user clicks on the time option from the menu")
    public void the_user_clicks_on_the_time_option_from_the_menu() {
    	try {
			Thread.sleep(3000);
			HomePage.getInstance().clickTimesheet();
	    	LOGGER.info("the user clicks on the time option from the Menu bar");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			CommonUtils.getInstance().takeScreenshot();
			LOGGER.error("Error while clicking on time option: " + e.getMessage());
		}  
    }

    @When("the user enters the name as {string}")
    public void the_user_enters_the_name_as(String empName) {
        try {
        	Thread.sleep(3000);
        	TimeSheetPage.getInstance().clickNameTextBox();
        	TimeSheetPage.getInstance().enterTimesheet(empName);
        	Thread.sleep(3000);
        	TimeSheetPage.getInstance().enterValue();
        	
			LOGGER.info("the user enters the name as Thomas Kutty Benny");	
		} catch (Exception e) {
			// TODO: handle exception
			CommonUtils.getInstance().takeScreenshot();
			LOGGER.error("Error while entering name: " + e.getMessage());
		}
    }

    @When("clicks on the view button")
    public void clicks_on_the_view_button() {
       try {
    	   TimeSheetPage.getInstance().clickSubmit();
    	   LOGGER.info("clicks on the view button");
	} catch (Exception e) {
		// TODO: handle exception
		CommonUtils.getInstance().takeScreenshot();
		LOGGER.error("Error while clicking on view button: " + e.getMessage());
	}
    }

    @Then("the user should see the message as {string}")
    public void the_user_should_see_the_message_as(String message) {
        LOGGER.info("the user should see the message as There are no pending timesheets to approve");
        try {
			Thread.sleep(3000);
			String actualMessage = ViewTimeSheetPage.getInstance().getTimeSheetPeriod();
			if(actualMessage.equals(message)) {
				LOGGER.info("The expected message is displayed: " + actualMessage);
			} else {
				LOGGER.error("The expected message is NOT displayed. Actual message: " + actualMessage);
			}
    } catch (Exception e) {
    	CommonUtils.getInstance().takeScreenshot();
    	LOGGER.error("Error while fetching message: " + e.getMessage());
    }
    }
}
