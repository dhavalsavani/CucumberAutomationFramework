package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import beans.test.context.DressesPagecontext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import pages.DressesPage;

public class DressesSteps {

	private DressesPage dressesPage;
	private DressesPagecontext dressesPagecontext;

	public DressesSteps(DressesPage dressesPage, DressesPagecontext dressesPagecontext) {
		this.dressesPage = dressesPage;
		this.dressesPagecontext = dressesPagecontext;
	}
	
	@When("I add my favourite dresses to cart")
	public void i_add_my_favourite_dresses_to_cart(DataTable dresses) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		for (String d : dresses.asList()) {
			dressesPage.hoverTheProduct(d);
			dressesPage.clickOnAddToCartLink();
			dressesPage.clickOnContinueShoppingButton();
		}
		dressesPagecontext.setCartItemCount(dresses.asList().size());
	}
	
	@Then("I should see dresses added into the cart")
	public void i_should_see_dresses_added_into_the_cart() {
	    assertTrue("Cart item count mismatch!!", dressesPage.getCartText().contains(String.valueOf(dressesPagecontext.getCartItemCount())));
	}
}