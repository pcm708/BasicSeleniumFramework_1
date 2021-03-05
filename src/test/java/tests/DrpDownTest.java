package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class DrpDownTest extends BaseTest{
	
	LoginPage loginPage;
	
	public DrpDownTest() {
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void login() {
		loginPage.enterCreds();
	}
}