package steps;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;

public class HomeSteps {

	private HomePage homePage;

	public HomeSteps(HomePage homePage) {
		this.homePage = homePage;
	}
	
	@Then("I validate practice website title is ([^\"]*)")
	public void i_validate_practice_website_title_is_My_Store(String title) {
	    assertEquals("Ooops landed on different page!", title, homePage.getTitle());
	}
	
	@When("I Go to Dresses menu")
	public void i_Go_to_Dresses_menu() {
		homePage.clickOnDressesLink();
	}
}