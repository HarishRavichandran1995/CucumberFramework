package com.dlh.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
					glue = "com.dlh.step_definitions",
					dryRun = false,
					monochrome = true,
					plugin = {"rerun:target/failed_scenarios.txt",
							  "pretty",
							  "html:target/cucumber-reports.html",
							  "json:target/cucumber-reports.json",
							  "junit:target/cucumber-reports.xml",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
							 )
public class TestRunner {
	

}
