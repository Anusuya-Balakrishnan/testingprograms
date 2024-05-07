package testngPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenerExample extends InstanceClass implements ITestListener  {
	public ExtentReports extent;
	public ExtentTest test;
	public void onStart(ITestContext context) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("on test suite start");
		extent = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/extentExampleAttachScreenshot.html");
        extent.attachReporter(htmlReporter);
		
	}
	public void onFinish(ITestContext context) {
		System.out.println("on test suite finish");
        extent.flush();
        driver.quit();
	}
	public void onTestStart(ITestResult result) {
		System.out.println("on test method start");
		test = extent.createTest(result.getName());
        test.assignAuthor("Ocean Testing");
        test.assignCategory("Smoke Testing");
        test.log(Status.INFO, "Test Execution Started: " + result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		 System.out.println("on test method success");
	        test.log(Status.PASS, "Test Passed");
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("on test method failed");

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("target/screenshot.png"));
            test.fail("Test Case Failed");
            test.addScreenCaptureFromPath("target/screenshot.png", "Test Case Failure Screenshot");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
