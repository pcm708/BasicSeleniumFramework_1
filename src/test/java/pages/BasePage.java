package pages;

import static utils.ConfigPropertyReader.getProperty;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

public class BasePage {
	
	WebDriver driver;
	ElementUtil el;
	
	public BasePage(WebDriver driver) {
		this.driver  = driver;
		el= new ElementUtil(driver);
	}
	
	public void launchApplication() {
		driver.manage().window().maximize();
		driver.get(getProperty("url"));
	}
	
	public void closeApplication() {
		driver.quit();
	}
}