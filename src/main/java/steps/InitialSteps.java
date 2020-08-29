package steps;

import core.DriverManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class InitialSteps {

	@Given("I want explore Cucumber features")
	public void i_want_explore_Cucumber_features() {
		System.out.println("Great!!");
	}
	
	@When("I open the automation practice {string}")
	public void i_open_the_automation_practice(String url) {
	    DriverManager.getDriver().get(url);
	}
}