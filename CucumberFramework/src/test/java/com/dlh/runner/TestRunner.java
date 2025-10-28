package com.dlh.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
					glue = "com.dlh.step_definitions",
					dryRun = false,
					monochrome = true)
public class TestRunner {

}
