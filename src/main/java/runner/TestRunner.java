package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/main/resources/features"}
		,glue = "steps"
		,plugin = {
				
				//for Simple Cucumber Reports
//				"usage",
				"pretty",
//				"html:target/cucumber-report",
//				"json:target/cucumber-report/Cucumber.json",
//				"junit:target/cucumber-report/Cucumber.xml",
				
				//For Extent Reports
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//				"plugins.NavigationalReportGeneratorPlugin",
				}
//		,tags = {"not @skip"}
		,tags = {"@run"}
		,monochrome = true
		)
public class TestRunner {

}
