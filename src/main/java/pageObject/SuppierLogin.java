package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuppierLogin {
private WebDriver driver;

public SuppierLogin(WebDriver driver){
	this.driver=driver;
}

	private By email= By.xpath("/html/body/div[2]/form[1]/div[1]/label[1]/input");
	private By password = By.xpath("/html/body/div[2]/form[1]/div[1]/label[2]/input");
	private By login = By.xpath("/html/body/div[2]/form[1]/button");
	private By error = By.xpath("/html[1]/body[1]/div[2]/form[1]/div[2]/div[1]");

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getpassword() {
		return driver.findElement(password);
	}
	public WebElement getLoginButton() {
		return driver.findElement(login);
	}
	public WebElement getLoginError() {
		return driver.findElement(error);
	}


}
