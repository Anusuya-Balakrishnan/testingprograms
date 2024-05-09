package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorSteps {
	
	int number1,number2,result;
	@Given("I have entered the number1 {int}")
	public void iHaveEnteredTheNumber1(Integer number1) {
		System.out.println("number1"+number1);
	    this.number1=number1;
	}
	@Given("I have entered the number2 {int}")
	public void iHaveEnteredTheNumber2(Integer number2) {
	   System.out.println("number2"+number2);
		this.number2=number2;
	}
	@When("I add the numbers")
	public void iAddTheNumbers() {
	    this.result=number1+number2;
	}
	@Then("the result should be {int}")
	public void theResultShouldBe(Integer result) {
	   Assert.assertEquals(result,this.result);
	   System.out.println("test case passed"+result);
	}

}
