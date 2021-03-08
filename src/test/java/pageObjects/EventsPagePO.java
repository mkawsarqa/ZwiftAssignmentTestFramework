package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EventsPagePO {
	
	public WebDriver driver;
	
	By filterEvents = By.xpath("//button[contains(text(),'Filter events')]");
	By cyclingSports =By.xpath("//button[contains(text(),'Cycling')]");
	By fondoEventsType = By.xpath("//button[contains(text(),'Fondo')]");
	By intensitiesB = By.xpath("//button[contains(text(),'B')]");
	By eventTimeAfternoon = By.xpath("//button[contains(text(),'Afternoon')]");
	By applyFilter = By.xpath("//span[contains(text(),'apply filters')]");
	By eventSearchResults = By.xpath("//div[contains(text(),'No results.')]");
	
	
	public EventsPagePO(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement clickOnFilterEventsButton () {
		return driver.findElement(filterEvents);
	}
	
	public WebElement clickToSelectSportsCycling () {
		return driver.findElement(cyclingSports);
	}
	
	public WebElement clickToSelectFondoEventType () {
		return driver.findElement(fondoEventsType);
	}
	
	public WebElement clickToSelectIntensitiesB () {
		return driver.findElement(intensitiesB);
	}
	
	public WebElement clickToSelectEventTime() {
		return driver.findElement(eventTimeAfternoon);	
	}
	
	public WebElement clickOnApplyFilter () {
		return driver.findElement(applyFilter);
	}
	
	public WebElement getEventSearchResluts() {
		return driver.findElement(eventSearchResults);
	}

}
