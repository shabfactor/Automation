package nz.co.maveros.auto.ghost.selenium;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
