package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BaseDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

	private static TakesScreenshot ts;

	public static void takeSnippet(String testCase, WebDriver driver) throws IOException {
		ts = (TakesScreenshot) driver;
		File f1 = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1, new File(System.getProperty("user.dir") + "\\Reports\\Screenshots" + testCase + ".png"));

	}

	public static void takeElementScreenshots(WebElement element, String testCase) {

		File f2 = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f2, new File(System.getProperty("user.dir") + "\\Reports\\Screenshots" + testCase + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
