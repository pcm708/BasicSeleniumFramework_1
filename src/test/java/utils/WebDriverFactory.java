package utils;

import static utils.ConfigPropertyReader.getProperty;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	public WebDriver getBrowserDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			if (Boolean.parseBoolean(getProperty("remote"))) {
				getRemoteWebDriver(browser);
			} else
				return new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (Boolean.parseBoolean(getProperty("remote"))) {
				getRemoteWebDriver(browser);
			} else 
				return new FirefoxDriver();
		}
		return new ChromeDriver();
	}
	
	private WebDriver getRemoteWebDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			try {
				return new RemoteWebDriver(new URL(getProperty("huburl")), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			try {
				return new RemoteWebDriver(new URL(getProperty("huburl")), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return  null;
	}
}