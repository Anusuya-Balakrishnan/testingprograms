package hooks;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.cucumber.java.Scenario;


public class DemoHook extends DriverInstance{
	
	@Before
	public void beforeScenario(Scenario scenario) {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		
		
		if (scenario.isFailed()) {
			
			TakesScreenshot ts = (TakesScreenshot) driver;

			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "failed test");
        }
		driver.quit();
		
	}
	
//	@BeforeStep
//	public void beforeStep() {
//		System.out.println("Before each step");
//	}
//	
//	@AfterStep
//	public void afterStep() {
//		System.out.println("after each step");
//		
//	}
	
}
