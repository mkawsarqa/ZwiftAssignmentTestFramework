package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import pageObjects.BaseDriver;
import utils.Screenshot;

public class TestNGListeners extends BaseDriver implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("The testcase"+" "+ result.getName()+" " + "is successfully started.");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("The testcase"+" "+ result.getName()+" " + "is successfully executed and passed.");
	} 

	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("The testcase"+" "+ result.getName()+" " + "is executed but failed.");
		
		String methodName = result.getName();
		
	
			try {
				Screenshot.takeSnippet(methodName, driver);
			} catch (IOException e) {
				e.printStackTrace();
			} 
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("The testcase"+" "+ result.getName()+" " + "is skipped.");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}


}
