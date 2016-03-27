package nz.co.maveros.auto.ghost.selenium;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nz.co.maveros.auto.ghost.configuration.AutoConfig;

public class Driver {
	
	private static WebDriver wb;
	
	private static AutoConfig config = AutoConfig.getInstance();
	
	public synchronized static WebDriver get() {
		if (wb == null) {
			wb = getDriverByType();
		}
		return wb;
	}
	
	/**
	 * Load ghost application url (ghost domain + page url).
	 * @param url
	 */
	public static void loadAppUrl(String url) {
		get().navigate().to(config.getAppHostname() + url);
	}
	
	/**
	 * Generic load any url.
	 * @param url
	 */
	public static void load(String url) {
		get().navigate().to(url);
	}
	
	public static WebElement findElementByXpath(String xpath) {
		return waitFor(By.xpath(xpath));
	}
	
	public static WebElement findElementByCssSelector(String cssSelector) {
		return waitFor(By.cssSelector(cssSelector));
	}
	
	public static WebElement findElementById(String id) {
		return waitFor(By.id(id));
	}
	
	private static WebElement waitFor(By by) {
		return (new WebDriverWait(get(), config.getElementWaitFor()))
				.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public static WebElement findElementByTagName(String tagName) {
		return (new WebDriverWait(get(), config.getElementWaitFor()))
				  .until(ExpectedConditions.presenceOfElementLocated(ByTagName.tagName(tagName)));
	}
	
	public static WebElement findElementClickable(By by) {
		return (new WebDriverWait(get(), config.getElementWaitFor()))
	.until(ExpectedConditions.elementToBeClickable((by)));
	}
	
	private static WebDriver getDriverByType() {
		
		DriverType driverType = config.getDriverType();
		String driverLocation = config.getDriverLocation();
		String driverProperty = String.format("webdriver.%s.driver", driverType.name().toLowerCase());
		
		if (StringUtils.isNotBlank(driverLocation)) {
			System.setProperty(driverProperty, driverLocation);
		}

		if (DriverType.IE == driverType) {
			return new InternetExplorerDriver();
		}
		
		if (DriverType.Chrome == driverType) {
			return new ChromeDriver();
		}
		
		return new FirefoxDriver();
	}
	
}
