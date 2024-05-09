package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search1 {
	@Given("the user is on the search page")
	public void theUserIsOnTheSearchPage() {
		System.out.println("the user is on the search page");
	}
	@When("the user searches for product1 {string}")
	public void theUserSearchesForProduct1(String string) {
		System.out.println("the user searches for product1"+string);
	}
	@Then("search results should be displayed")
	public void searchResultsShouldBeDisplayed() {
		System.out.println("search results should be displayed");
	    
	}

}
