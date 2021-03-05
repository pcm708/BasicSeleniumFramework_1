package tests;

import static utils.ConfigPropertyReader.getProperty;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.BasePage;
import utils.WebDriverFactory;

public class BaseTest {
	
	WebDriver driver;
	WebDriverFactory wdFactory;
	BasePage basePage;
	
	public BaseTest() {
		wdFactory=new WebDriverFactory();
		driver=wdFactory.getBrowserDriver(getProperty("browser"));
		basePage = new BasePage(driver);
	}
	
	@BeforeTest
	public void setup() {
		basePage.launchApplication();
	}
	
	@AfterTest
	public void tearDown() {
		basePage.closeApplication();
	}
}
