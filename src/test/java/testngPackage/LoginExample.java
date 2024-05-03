package testngPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginExample  extends InstanceClass{
	
	
	@DataProvider(name="loginData")
public Object[][] data() throws FileNotFoundException {
	Object[][] arrayData=new Object[4][2];
		
		try {
			FileInputStream file=new FileInputStream("data.xlsx");

			XSSFWorkbook excelFile = new XSSFWorkbook(file);
			XSSFSheet sheet = excelFile.getSheet("Sheet1");
		
			
			
//			{{1,12},{2,45},{},{}}
			int noOfRows=sheet.getLastRowNum();
			for(int i=1;i<=noOfRows;i++) {
				XSSFRow row = sheet.getRow(i);
				int noOfColumn=row.getLastCellNum();
				for (int j=0;j<noOfColumn;j++) {
					arrayData[i-1][j]=row.getCell(j).getStringCellValue();
					
				}
			}
//			for(int i=0;i<arrayData.length;i++) {
//				
//				
//				for (int j=0;j<arrayData[i].length;j++) {
//					System.out.print(arrayData[i][j]+" ");	
//				}
//				System.out.println(" ");
//			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayData;
		
	}
	
	
	public Object[][] getData(){
		Object[][] data= {{"standard_user","secret_sauce"},
				{"locked_out_user","secret_sauce"},
				{"problem_user","secret_sauce"},
				{"performance_glitch_user","secret_sauce"},
				};
		return data;
	}
	
	@Test(dataProvider = "loginData")
	public void login(String username,String password) {
		
		driver.get("https://www.saucedemo.com/v1/");
		
		WebElement usernameElement = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//input[@id='user-name']")));
		usernameElement.sendKeys(username);
		WebElement passwordElement = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//input[@id='password']")));
		passwordElement.sendKeys(password);
		WebElement loginBtnElement = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//input[@id='login-button']")));
		loginBtnElement.click();
		
		String expectedUrl="https://www.saucedemo.com/v1/inventory.html";
		String actualUrl=driver.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, expectedUrl);
		
	}
}
