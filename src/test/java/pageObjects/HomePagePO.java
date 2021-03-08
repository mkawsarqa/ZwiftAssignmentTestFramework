package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Waits;

public class HomePagePO {
	
	Waits w= new Waits();
	
	public WebDriver driver;
	
	By gettingStart_txt=By.xpath("//span[contains(text(), 'Getting started is easy')]");
	By signIn_btn=By.xpath("//span[contains(text(), 'Sign In')]");
	By navBarList_btn= By.xpath("//button[@aria-controls='side-nav']");
	By events_lnkBtn=By.xpath("//span[contains(text(),'Events')]");
	
	
	public HomePagePO(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean textOfGettingStarted () throws InterruptedException {

		Thread.sleep(15000L);
		return w.isElementDisplayed(gettingStart_txt);
		
	} 
	
	public WebElement clickOnSignInButton() throws InterruptedException {
		Thread.sleep(10000L);
		return driver.findElement(signIn_btn);
		
	}
	
	public WebElement clicTopNavBarRightSideMenuButton() {
		return driver.findElement(navBarList_btn);
	}
	
	public WebElement clickOnEventsLinkButton () {
		return driver.findElement(events_lnkBtn);
	}


}
