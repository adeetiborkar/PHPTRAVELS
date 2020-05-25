package GaneshBorkar.NSE;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.SuppierLogin;
import resources.Base;

public class SupplerLogin2 extends Base {

	public WebDriver driver;
	public SuppierLogin slogin;

	@BeforeTest
	public void initializeDriver() throws IOException {
		driver = intializeDriver();
		//driver.get("https://www.phptravels.net/supplier/");
		
	}
	
	@Test(dataProvider = "dataSet")
	// Try to login Supplier Login at footer of page
	public void login(String username, String password) throws InterruptedException {
		
		slogin=new SuppierLogin(driver);
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("/html/body/div[2]/form[1]/div[1]/h2/strong")).getText());
		slogin.getEmail().sendKeys(username);
		slogin.getpassword().sendKeys(password);
		slogin.getLoginButton().click();
		String error = slogin.getLoginError().getText();
		System.out.println(error);
	}
	
	@DataProvider 
	public Object[][] dataSet() {

		Object[][] data = new Object[1][2];
		data[0][0] = "abcdefg@sfffff.com";
		data[0][1] = "Adfjn223232";
	/*	data[1][0] = "afbabjfkja@kjdgsj.com";
		data[1][1] = "kjfndndkjfnlfklf24x";
		data[2][0] = " user@phptravels.com";
		data[2][1] = "demouser";
		*/
		return data;

	}

	
	
	
	
}