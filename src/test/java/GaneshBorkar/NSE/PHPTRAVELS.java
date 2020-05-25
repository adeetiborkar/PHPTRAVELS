package GaneshBorkar.NSE;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.HomePage;
import resources.Base;


public class PHPTRAVELS extends Base{

	public WebDriver driver;
	public HomePage hpage;
	
	@BeforeTest
	public void initializeDrive() throws IOException
	{
		driver=intializeDriver();
		
	}
	
	@Test(priority=0)
	//To check the https://www.phptravels.net/home is loaded successfully.
	public void validateTitle() {
	Assert.assertEquals(driver.getTitle(), "PHPTRAVELS | Travel Technology Partner");
	//System.out.println(driver.getTitle());
	
	}
	
	@Test(priority=1)
	//To verify "Latest On Blogs" is displayed 
	public void ValidateText() {
		hpage= new HomePage(driver);
		String text = hpage.getBlogText();
		Assert.assertEquals(text, "Latest On Blogs");
	}
	@Test(priority=2, enabled=false)
	//Try to book return flight ticket From Chennai to Paris
	public void bookReturnTicket() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		hpage.getFilght().click();
		hpage.getReturnTicket().click();
	//	hpage.getBussinesClass().click();
	//	hpage.getTravellersClass().sendKeys(Keys.UP);
		hpage.getTo().click();
		hpage.getTo().sendKeys("paris");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'(PHT)')]")).click();
		hpage.getFrom().click();;
		hpage.getFrom().sendKeys("chennai");
		Thread.sleep(1000);
		hpage.getFrom().sendKeys(Keys.ENTER);
	
		hpage.getAddAudlts().click();
		hpage.getAddAudlts().click();
		hpage.getAddChild().click();
		hpage.getAddChild().click();
		hpage.getsearch_Trevellers().click();
		Thread.sleep(2000);
		String text= driver.findElement(By.cssSelector("h3[class='heading-title'] span")).getText();
		Assert.assertEquals(text, "MAA to");

	}
	
	@Test(priority=3)
	//Get links present under "Support" and click on "Terms of use"
	public void getTerms_of_use() {
		driver.findElement(By.xpath("//*[@id=\'cookyGotItBtnBox\']/div/button")).click();;
		List<WebElement> supportLinks= hpage.getSUPPORT().findElements(By.tagName("li"));
		int links = supportLinks.size();
		Assert.assertEquals(links, 4);
		String keypress = Keys.chord(Keys.CONTROL,Keys.ENTER);
		hpage.getSUPPORT().findElement(By.linkText("Terms of Use")).sendKeys(keypress);;
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it =ids.iterator();
		String newWindow =it.next();
		String title= driver.switchTo().window(newWindow).getTitle();
		Assert.assertEquals(title, "PHPTRAVELS | Travel Technology Partner");
	}
	

	@AfterTest
	
	public void tearDown1() {

		driver.quit();
	}

}

	
	