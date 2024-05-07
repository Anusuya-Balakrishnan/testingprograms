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
	@Given("user select username element and enter username value")
	public void userSelectUsernameElementAndEnterUsernameValue() {
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='user-name']"));
		usernameElement.sendKeys("standard_user");
	}
	@Given("user select password element and enter password value")
	public void userSelectPasswordElementAndEnterPasswordValue() {
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
		passwordElement.sendKeys("secret_sauce");
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
}
