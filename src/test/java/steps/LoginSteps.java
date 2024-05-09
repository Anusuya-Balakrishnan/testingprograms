package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	
	public  RemoteWebDriver driver;
	public  WebDriverWait wait;
	@Given("user navigate to the sauce demo website")
	public void userNavigateToTheSauceDemoWebsite() {
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.saucedemo.com/v1/");
	}
	@Given("user select username element and enter username {string}")
	public void userSelectUsernameElementAndEnterUsername(String username) {
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='user-name']"));
		usernameElement.sendKeys(username);
	}
	@Given("user select password element and enter password {string}")
	public void userSelectPasswordElementAndEnterPassword(String password) {
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
		passwordElement.sendKeys(password);
	}
	@When("User click the login button")
	public void userClickTheLoginButton() {
		WebElement loginBtnElement =driver.findElement(By.xpath("//input[@id='login-button']"));
		loginBtnElement.click();  
	}
	@Then("user should move to home page")
	public void userShouldMoveToHomePage() {
		String expectedUrl="https://www.saucedemo.com/v1/inventory.html";
		String actualUrl=driver.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, expectedUrl);
		
	}
	
//	@Given("the user is on the login page")
//	public void theUserIsOnTheLoginPage() {
//	    System.out.println("the user is on the login page");
//	}
//	@When("the user enters {string} and {string}")
//	public void theUserEntersAnd(String string1, String string2) {
//	    System.out.println("the user enters username"+string1+"and password"+string2);
//	}
//	@When("clicks on the login button")
//	public void clicksOnTheLoginButton() {
//	    System.out.println("clicks on the login button");
//	}
//	@Then("the user should be redirected to the dashboard")
//	public void theUserShouldBeRedirectedToTheDashboard() {
//	   System.out.println("the user should be redirected to the dashboard");
//	}
}
