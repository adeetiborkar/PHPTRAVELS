package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By filght = By.xpath("//a[contains(@class,'text-center flights')]");
	private By hotel = By.xpath("//a[@class='text-center hotels active']");
	private By carHire = By.xpath("///a[contains(@class,'text-center cars')]");
	private By returnT = By.xpath("//label[contains(text(),'Round Trip')]");
	private By oneway = By.xpath("//label[contains(text(),'One Way')]");
	private By from = By.xpath("//*[@id=\"s2id_location_from\"]/a");
	private By to = By.xpath("//*[@id=\"s2id_location_to\"]/a");
	private By departDate = By.id("FlightsDateStart");
	private By returnDate = By.id("FlightsDateEnd");
	private By classTravelers = By.xpath("//span[contains(text(),'Economy')]");
	private By bussinesclass = By.xpath("//li[contains(text(),'Business')]");
	private By addAdults = By.xpath(
			"//div[contains(@class,'row no-gutters mb-15 row-reverse')]//div[contains(@class,'row no-gutters')]//div[1]//div[1]//div[2]//div[1]//span[1]//button[1]");
	private By addChild = By
			.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/span/button[1]");
	private By infant = By
			.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[3]/div/div/div[3]/div/div[2]/div/span/button[1]");
	private By searchButton = By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[4]/button");
	private By blog = By.xpath("//h2[contains(text(),'Latest on blogs')]");
	private By support = By.xpath("//*[@id=\"footer\"]/div[1]/div[1]/div[2]/div/div/div[1]/ul/li[2]");
	private By supplierLogin = By.xpath("//a[contains(text(),'Supplier Login')]");
	private By cookieButton = By.xpath("//*[@id=\'cookyGotItBtnBox\']/div/button");
 
	public WebElement getFilght() {
		return driver.findElement(filght);
	}

	public WebElement getHotel() {
		return driver.findElement(hotel);
	}

	public WebElement getCarHire() {
		return driver.findElement(carHire);
	}

	public WebElement getReturnTicket() {
		return driver.findElement(returnT);
	}

	public WebElement getOneWayTicket() {
		return driver.findElement(oneway);
	}

	public WebElement getFrom() {
		return driver.findElement(from);
	}

	public WebElement getTo() {
		return driver.findElement(to);
	}

	public WebElement getDepatrtureDate() {
		return driver.findElement(departDate);
	}

	public WebElement getReturnDate() {
		return driver.findElement(returnDate);
	}

	public WebElement getTravellersClass() {
		return driver.findElement(classTravelers);
	}

	public WebElement getBussinesClass() {
		return driver.findElement(bussinesclass);
	}

	public WebElement getAddAudlts() {
		return driver.findElement(addAdults);
	}

	public WebElement getAddChild() {
		return driver.findElement(addChild);
	}

	public WebElement getsearch_Trevellers() {
		return driver.findElement(searchButton);
	}

	public WebElement getInfant() {
		return driver.findElement(infant);
	}

	public String getBlogText() {
		return driver.findElement(blog).getText();
	}
	
	public void getSuplierLogin() {
		//WebElement footer =driver.findElement(By.xpath("//footer[@id='footer']"));
		driver.findElement(supplierLogin).click();
		
		 
	}
	public WebElement getSUPPORT() {
		return driver.findElement(support);
		 
	}

	public void getCookieButton() {
		 driver.findElement(cookieButton).click();;
		 
	}
	
}
