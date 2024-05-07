package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoSteps {
	@Given("I am on career.guru99.com")
	public void iAmOnCareerGuru99Com() {
	   System.out.println("I am on career.guru99.com");
	}
	@When("I click on career guide menu")
	public void iClickOnCareerGuideMenu() {
		System.out.println("I click on career guide menu");
	    
	}
	@Then("I should see career guide page")
	public void iShouldSeeCareerGuidePage() {
		System.out.println("I should see career guide page");
	    
	}

}
