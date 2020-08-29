package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(

		features = { "src/main/resources/features" }, 
		glue = "steps", 
		plugin = {
				//for Simple Cucumber Reports
				//"usage",
				"pretty",
				"html:target/cucumber-report",
				"json:target/cucumber-report/Cucumber.json",
				"junit:target/cucumber-report/Cucumber.xml",
		}, 
		//tags = {"not @skip"}, 
		tags = { "@tag2" }, 
		monochrome = true
		)
public class TestRunner {}