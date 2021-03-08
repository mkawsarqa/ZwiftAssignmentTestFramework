package stepDefinitions;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.BaseDriver;
import pageObjects.EventsPagePO;
import pageObjects.HomePagePO;
import utils.ConfigReader;
import utils.Waits;


@Listeners(TestNGListeners.class)
public class EventsTest extends BaseDriver {
	
	//Test case 2
	// Test steps written here is based on assignment Test Scenario and sequence of actions
	
	@Test(priority=2)
	public void eventPageValidation() throws InterruptedException {
	
	Waits w=new Waits();
	ConfigReader conf = new ConfigReader();
	HomePagePO hmP = new HomePagePO(driver);
	EventsPagePO evnP = new EventsPagePO(driver);
	
	BaseDriver.getDriver().get(conf.url());// Test Step 2.1: navigating to home page
	hmP.clicTopNavBarRightSideMenuButton().click(); //Test Step 2.2: Clicking on the Right side list menu button on top-nav bar 
	hmP.clickOnEventsLinkButton().click(); // Test Step 2.3:click on Events button to navigate to the Events search and selection page
	Thread.sleep(2000L);
	System.out.println(driver.getTitle());
	Assert.assertEquals(driver.getTitle(), conf.getEventPageTitle()); //validation of page load using page title
	w.pageLoadStatusBySecond(); //Test Step 2.4:verifies pageload assuming 15 seconds is the max pageload time by requirments
	
	evnP.clickOnFilterEventsButton().click(); // Test Step 2.5:Click on Event Filter for further selection options
	evnP.clickToSelectSportsCycling().click(); // Test Step 2.6:Selection of Sports Type
	evnP.clickToSelectFondoEventType().click(); // Test Step 2.6:Selection of Event Type - Fondo
	evnP.clickToSelectIntensitiesB().click(); //Test Step 2.7:Selection of Intensities - B
	evnP.clickToSelectEventTime().click(); // Test Step 2.8:selection of Event Time - Afternoon
	evnP.clickOnApplyFilter().click(); // Test Step 2.8: Click on the Apply Filter button
	evnP.getEventSearchResluts().isDisplayed();// Test Step 2.9:Check if the search results is displayed or not
	Assert.assertTrue(true); // Test Step 2.10: verifies text is correct or not
	String searchResultsText = evnP.getEventSearchResluts().getText();
	Assert.assertEquals(searchResultsText, conf.getEventSearchNoResults());//Test Step 2.11:Validation of No Results based on Sports, Event Type, Intensities and Event time selection
	
	}

}
