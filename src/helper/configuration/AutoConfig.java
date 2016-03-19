package helper.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import helper.driver.DriverType;

public class AutoConfig {
	
	private static final String CONFIG_FILE = "env.properties";
	
	private static Configuration config;

	private static AutoConfig instance = new AutoConfig();
	
	static {
		try {
			config = new PropertiesConfiguration(CONFIG_FILE);
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
	
}
