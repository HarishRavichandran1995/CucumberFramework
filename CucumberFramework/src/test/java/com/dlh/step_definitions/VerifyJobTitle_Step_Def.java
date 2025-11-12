package com.dlh.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.dlh.pageobjects.DirectoryPage;
import com.dlh.pageobjects.HomePage;
import com.dlh.pageobjects.LoginPage;
import com.dlh.webdriver_manager.DriverManager;
import com.lao.constants.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyJobTitle_Step_Def {

	private static final Logger LOGGER = LogManager.getLogger(VerifyJobTitle_Step_Def.class);
	
	@Given("the user is logged in successfully and is on Home Page")
    public void the_user_is_logged_in_successfully_and_is_on_home_page() {
		DriverManager.getDriver().get(Constants.APP_URL);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LoginPage.getInstance().getUSERNAME().sendKeys(Constants.USERNAME);
		LoginPage.getInstance().getPASSWORD().sendKeys(Constants.PASSWORD);
		LoginPage.getInstance().getSUBMIT().click();
		
		String url = DriverManager.getDriver().getCurrentUrl();
		if(url.contains("dashboard")) {
			LOGGER.info("User is logged on successfully and is on Home Page");
		}
    }

    @When("the user clicks on the directory option from the Menu bar")
    public void the_user_clicks_on_the_directory_option_from_the_menu_bar() {
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	HomePage.getInstance().getDIRECTORY().click();
    	LOGGER.info("the user clicks on the directory option from the Menu bar");
    	}

    @When("the user selects job title as {string} from the drop down")
    public void the_user_selects_job_title_as_from_the_drop_down(String empName) {
    	LOGGER.info("the user selects job title as CFO from the drop down");
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	DirectoryPage.getInstance().getJOBTITLEDROPDOWN().click();
    	try {
			Thread.sleep(3000);
			DirectoryPage.getInstance().getJOBTITLE().click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }

    @When("clicks the search button")
    public void clicks_the_search_button() {
    	LOGGER.info("clicks the search button");
    	DirectoryPage.getInstance().getSEARCHBUTTON().click();
    }

    @Then("the user should see the emp name as {string}")
    public void the_user_should_see_the_emp_name_as(String empName) {
    	LOGGER.info("the user should see the job title for Emp as {string}");
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String actualName = DirectoryPage.getInstance().getFETCHNAME().getText();
    	if (actualName.equals(empName)) {
    		LOGGER.info("EMP Name matches");
		}
    }
}
