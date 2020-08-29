package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"target/parallel/features/[CUCABLE:FEATURE].feature"}, 
        plugin = {"json:target/cucumber-report/[CUCABLE:RUNNER].json"}, 
		
		
		/*features = {"src/main/resources/features"}, 
		plugin = {
				//for Simple Cucumber Reports
//				"usage",
				"pretty", 
				"html:reports/cucumber-reports", 
				"json:reports/cucumber-reports/Cucumber.json", 
				"junit:reports/cucumber-reports/Cucumber.xml"
				}, */
//		tags = {"not @skip"}, 
		monochrome = true, 
		glue = "steps"
		)
public class ParalleTestRunner {}
