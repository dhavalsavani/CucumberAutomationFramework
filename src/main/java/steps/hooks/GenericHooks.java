package steps.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class GenericHooks {

	/**
	 * This method is a After hook for taking screenshot of failed scenario.
	 * 
	 * @param scenario - Scenario instance
	 */
	@After(order = 100)
	public void takeScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			//Embedding screenshot of failure
			scenario.embed(
					((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
		}
	}
	
	/**
	 * hook to shutdown the browser and quit webdriver
	 */
	@After(order = 1)
	public void closeBrowser() {
		DriverManager.close();
	}
}