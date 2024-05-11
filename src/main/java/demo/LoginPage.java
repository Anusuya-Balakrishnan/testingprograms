package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage {

	public RemoteWebDriver driver;
	
	By userNameField=By.xpath("//input[@id='user-name']");
	By passwordField=By.xpath("//input[@id='password']");
	By loginBtn=By.xpath("//input[@id='login-button']");
	
	
	public LoginPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public void enterUserName(String username) {
		driver.findElement(userNameField).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	
}
