package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {


	private String url;
	private String browserLocation;
	private String browser;
	private String expectedUrl;
	private String logInformActualTitle;
	private String eventPageTitle;
	private String eventSearchNoResults;

	public ConfigReader() {

		Properties prop = new Properties();
		InputStream input = null;

		try {   	
			input = new FileInputStream("config/config.properties"); 
			prop.load(input); // load a properties file
			this.url=prop.getProperty("url");
			this.browserLocation = prop.getProperty("browserLocation");
			this.browser = prop.getProperty("browser");
			this.expectedUrl=prop.getProperty("expectedUrl");
			this.logInformActualTitle=prop.getProperty("logInformActualTitle");
			this.eventPageTitle=prop.getProperty("eventPageTitle");
			this.eventSearchNoResults=prop.getProperty("eventSearchNoResults");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	public String url() {
		return url;
	}
	public String getBrowserLocation() {

		return browserLocation;
	}

	public String browser() {
		return browser;

	}
	
	public String getExpectedUrl () {
		return expectedUrl;
	}
	
	public String getlogInformActualTitle() {
		return logInformActualTitle;
	}
	
	public String getEventPageTitle () {
		return eventPageTitle;
	}
	
	public String getEventSearchNoResults () {
		return eventSearchNoResults;
	}
}
