package com.dlh.step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyJobTitle_Step_Def {

	
	@Given("the user is logged in successfully and is on Home Page")
    public void the_user_is_logged_in_successfully_and_is_on_home_page() {
		System.out.println("the user is logged in successfully and is on Home Page");
    }

    @When("the user clicks on the directory option from the Menu bar")
    public void the_user_clicks_on_the_directory_option_from_the_menu_bar() {
    	System.out.println("the user clicks on the directory option from the Menu bar");
    }

    @When("the user enters the employee name as {string} from the drop down")
    public void the_user_enters_the_employee_name_as_from_the_drop_down(String empName) {
    	System.out.println("the user enters the employee name as {string} from the drop down");
    }

    @When("clicks the search button")
    public void clicks_the_search_button() {
    	System.out.println("clicks the search button");
    }

    @Then("the user should see the job title for Emp as {string}")
    public void the_user_should_see_the_job_title_for_emp_as(String empName) {
    	System.out.println("the user should see the job title for Emp as {string}");
    	
    }
}
