package nz.co.maveros.auto.ghost.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import nz.co.maveros.auto.ghost.model.page.LoginPage;
import nz.co.maveros.auto.ghost.selenium.Driver;

public class LoginServiceImpl implements LoginService {
	
	@Override
	public void loadPage() {
		Driver.loadAppUrl(LoginPage.LOGIN_URL);
	}

	@Override
	public LoginPage login(String email, String password) {
		LoginPage loginPage = new LoginPage(email, password);
		WebElement emailElement = Driver.findElementPresence(By.xpath("//input[contains(@type,'email')]"));
		WebElement passwordElement = Driver.findElementPresence(By.xpath("//input[contains(@type,'password')]"));
		emailElement.sendKeys(loginPage.getEmail());
		passwordElement.sendKeys(loginPage.getPassword());
		WebElement submitButton = Driver.findElementPresence(By.xpath("//button[contains(@class,'login btn')]"));
		submitButton.click();
		return loginPage;
	}

	@Override
	public void logout() {
		Driver.loadAppUrl("/ghost/signout/");
		
	}

}
