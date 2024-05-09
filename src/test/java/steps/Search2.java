package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search2 {
	
	@When("the user searches for product2 {string}")
	public void theUserSearchesForProduct2(String string) {
		System.out.println("the user searches for product2"+string);
	}
	
	@Then("search results for electronics should be displayed")
	public void searchResultsForElectronicsShouldBeDisplayed() {
		System.out.println("search results for electronics should be displayed");
	    
	}

}
