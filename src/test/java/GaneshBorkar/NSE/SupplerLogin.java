package GaneshBorkar.NSE;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SuppierLogin;
import resources.Base;

public class SupplerLogin extends Base {

	public WebDriver driver;
	public HomePage hpage;
	public SuppierLogin slogin;

	@BeforeTest
	public void initializeDriver() throws IOException {
		driver = intializeDriver();

	}
	@Test 
	public void login() throws InterruptedException {
		Thread.sleep(2000);
		hpage= new HomePage(driver);
		hpage.getCookieButton();
		
		hpage.getSuplierLogin();
		slogin=new SuppierLogin(driver);
		String parentWH = driver.getWindowHandle();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		 System.out.println("Parent=  "+ parentWH);
		 String childW=it.next();
		while(it.hasNext())
		{
			Thread.sleep(2000L);
			childW=it.next();
					
			driver.switchTo().window(childW);
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			System.out.println("child =  "+ driver.getWindowHandle());
		}
		System.out.println("child 2=  "+ driver.getWindowHandle());

	}
	
	@Test( dependsOnMethods = "login",  dataProvider = "dataSet")
	// Try to login Supplier Login at footer of page
	public void SuplierLogin(String username, String password) throws InterruptedException {
		slogin.getEmail().clear();
		slogin.getpassword().clear();
		Thread.sleep(4000);
		slogin.getEmail().sendKeys(username);
		slogin.getpassword().sendKeys(password);
		slogin.getLoginButton().click();
		String error = slogin.getLoginError().getText();
		System.out.println(error);
	
	}

	@DataProvider 
	public Object[][] dataSet() {

		Object[][] data = new Object[3][2];
		data[0][0] = "abcdefg@sfffff.com";
		data[0][1] = "Adfjn223232";
		data[1][0] = "afbabjfkja@kjdgsj.com";
		data[1][1] = "kjfndndkjfnlfklf24x";
		data[2][0] = " user@phptravels.com";
		data[2][1] = "demouser";
		
		return data;

	}

	@AfterTest
	
	public void tearDown() {

		driver.quit();
	}

}
