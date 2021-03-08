package pageObjects;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utils.ConfigReader;


public class BaseDriver{

	public static WebDriver driver = null;


	@BeforeTest
	public WebDriver driverInitialization() {

		ConfigReader configReader = new ConfigReader();

		if (configReader.browser().equals("chrome")) 
		{
			String chromeDr = "chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",
					configReader.getBrowserLocation()+chromeDr);

			
			driver = new ChromeDriver();

		} 

		else if (configReader.browser().equals("firefox")) 
		{
			String fireFxDr = "geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",
					configReader.getBrowserLocation()+fireFxDr);;
					driver = new FirefoxDriver();

		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}


	@AfterTest
	public void after() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			//driver.close(); //this may create NoSuchSessionException for FirefoxDriver
			driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
