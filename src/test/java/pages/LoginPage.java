package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	
	private By emailField = By.id("Email");
	private By pwdField = By.id("Password");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterCreds() {
		el.doSendKeys(emailField, "admin@yourstore.com");
		el.doSendKeys(pwdField, "admin");
		el.doActionsSendKeys(Keys.ENTER);
	}
}