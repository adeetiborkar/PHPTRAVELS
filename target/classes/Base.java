package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver intializeDriver() throws IOException {

		prop = new Properties();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(file);
		String browserName = prop.getProperty("browser");

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		// run testcase without invoking browser use ChromeOption
		ChromeOptions options = new ChromeOptions();
		if (browserName.contains("headless")) {
			options.addArguments("--headless");
		}
		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String url = prop.getProperty("URL");
		driver.get(url);

		return driver;

	}
	public String getScreenshot(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts =  (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String DestinationFile = System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
		FileUtils.copyFile(source,new File(DestinationFile));
		return DestinationFile;
	}

}
