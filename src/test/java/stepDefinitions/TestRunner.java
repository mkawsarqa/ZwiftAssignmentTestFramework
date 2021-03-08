package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestRunner {

	public static void main(String[] args) {

		
		TestNG testRunner = new TestNG();
		
		List <String> listTests = new ArrayList <String>();
		listTests.add("C:\\Users\\kawsa\\OneDrive\\Career\\QA Career Development\\Java Codes\\Zwift\\ZwiftAssignmentKawsar.xml");
		
		//Please make sure to change the project source path after cloning to the local machine for the xml file
		
		testRunner.setTestSuites(listTests);
		testRunner.run();
	}

}
