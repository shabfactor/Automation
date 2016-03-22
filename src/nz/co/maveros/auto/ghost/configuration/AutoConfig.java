package nz.co.maveros.auto.ghost.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;

import nz.co.maveros.auto.ghost.selenium.DriverType;

public class AutoConfig {
	
	private static final String CONFIG_FILE = "resources/env.properties";
	
	private static Configuration config;

	private static AutoConfig instance = new AutoConfig();
	
	static {
		try {
			config = new OverridePropertyConfiguration(CONFIG_FILE);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static AutoConfig getInstance() {
		return instance;
	}
	
	public DriverType getDriverType() {
		return DriverType.find(config.getString("auto.driver.type"));
	}
	
	public String getDriverLocation() {
		return config.getString("auto.driver.location." + getDriverType().name().toLowerCase());
	}
	public String getUserName() {
		return config.getString("auto.username");
	}
	public String getPassword() {
		return config.getString("auto.password");
	}
	
	public String getAppHostname() {
		return config.getString("app.ghost.hostname");
	}
	
	public long getElementWaitFor() {
		return config.getLong("auto.driver.element.waitfor");
	}
}
