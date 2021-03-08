package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPagePO {
	
	public WebDriver driver;
	
	By login_txt = By.xpath("//h1[contains(text(),'Log in')]");
	
	public SignInPagePO (WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement logInFormTitleText () {
		return driver.findElement(login_txt);
	} 

}
