package nz.co.maveros.auto.ghost.model.page;

import org.openqa.selenium.WebDriver;

import nz.co.maveros.auto.ghost.configuration.AutoConfig;

public abstract class AbstractPage {
	private String url;

	private WebDriver driver;

	public AbstractPage(WebDriver driver, String url) {
		super();
		this.driver = driver;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	protected void load() {
		driver.navigate().to(AutoConfig.getInstance().getAppHostname() + url);
	}
}
