package nz.co.maveros.auto.ghost.service;

import org.openqa.selenium.WebElement;

import nz.co.maveros.auto.ghost.configuration.AutoConfig;
import nz.co.maveros.auto.ghost.model.page.LoginPage;
import nz.co.maveros.auto.ghost.selenium.Driver;

public class LoginServiceImpl implements LoginService {
	
	private AutoConfig config = AutoConfig.getInstance();

	@Override
	public void loadPage() {
		Driver.load(config.getAppHostname() + LoginPage.LOGIN_URL);
	}

	@Override
	public LoginPage login(String email, String password) {
		LoginPage loginPage = new LoginPage(email, password);
		WebElement emailElement = Driver.findElementByXpath("//input[contains(@type,'email')]");
		WebElement passwordElement = Driver.findElementByXpath("//input[contains(@type,'password')]");
		emailElement.sendKeys(loginPage.getEmail());
		passwordElement.sendKeys(loginPage.getPassword());
		WebElement submitButton = Driver.findElementByXpath("//button[contains(@class,'login btn')]");
		submitButton.click();
		return loginPage;
	}

}
