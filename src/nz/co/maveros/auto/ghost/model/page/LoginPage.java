package nz.co.maveros.auto.ghost.model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import nz.co.maveros.auto.ghost.fixture.GhostPrimaryObjectFixture;

public class LoginPage extends AbstractPage {

	private WebElement email;

	private WebElement password;

	private WebElement submitButton;

	private final static String LOGIN_URL = "/login";

	public LoginPage(WebDriver driver) {
		super(driver, LOGIN_URL);

		load();
		GhostPrimaryObjectFixture.checkPageIsReady();

		this.email = driver.findElement(By.xpath("//input[contains(@type,'email')]"));
		this.password = driver.findElement(By.xpath("//input[contains(@type,'password')]"));
		this.submitButton = driver.findElement(By.xpath("//button[contains(@class,'login btn')]"));
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void submit() {
		submitButton.click();
	}

	public void inputEmail(String emailValue) {
		email.sendKeys(emailValue);
	}

	public void inputPassword(String passwordValue) {
		password.sendKeys(passwordValue);
	}
}
