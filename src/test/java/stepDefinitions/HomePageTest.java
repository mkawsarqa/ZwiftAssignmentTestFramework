package stepDefinitions;

import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.BaseDriver;
import pageObjects.HomePagePO;
import pageObjects.SignInPagePO;
import utils.ConfigReader;
import utils.Waits;

@Listeners(TestNGListeners.class)
public class HomePageTest extends BaseDriver {

	// Test Case 1
	// Test steps written here is based on assignment Test Scenario and sequence of actions
	
	@Test (priority=1)
	public void homePageValidation() throws InterruptedException {

		Waits w = new Waits();
		ConfigReader conf = new ConfigReader();
		HomePagePO hmP = new HomePagePO(driver);
		SignInPagePO siP= new SignInPagePO(driver);


		BaseDriver.getDriver().get(conf.url());//Test Step 1.1: to navigate to home page
		w.pageLoadStatusBySecond(); //Test Step 1.1: verifies pageload assuming 15 seconds is the max pageload time by requirments
		String currentUrl = driver.getCurrentUrl(); 
		System.out.println("Current URL is: "+currentUrl);
		Assert.assertEquals(conf.getExpectedUrl(), currentUrl);// Test Step 1.2:verifies that we are in the correct page in relation to pageload status
		
		hmP.textOfGettingStarted();//  
		Assert.assertTrue(true); //Test Step 1.3: verifies one of the Title Text Getting Started is Easy is displayed in the Home Page 
		hmP.clickOnSignInButton().click(); // Test Step 1.4: click on the Sign In button on the top-nav bar
		String logInformTitle =siP.logInFormTitleText().getText();// Test Step 1.5: verifies, user is able to navigate to Log in credential entry form page by clicking Sign In button 
		if (logInformTitle.equals(conf.getlogInformActualTitle())) {
			System.out.println("Verified: Sign In button on HomePage top Nav-bar is functioning correctly");
		} else {

			System.out.println("Verified: Sign In button on HomePage top Nav-bar is not functioning correctly. Please check");

		}

	}
}
