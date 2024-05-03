package testngPackage;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenerExample extends InstanceClass implements ITestListener  {

	public void onStart(ITestContext context) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("on test suite start");
		
	}
	public void onFinish(ITestContext context) {
		System.out.println("on test suite finish");
		driver.quit();
	}
	public void onTestStart(ITestResult result) {
		System.out.println("on test method start");
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test method success");
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("on test method failed");
	}
}
