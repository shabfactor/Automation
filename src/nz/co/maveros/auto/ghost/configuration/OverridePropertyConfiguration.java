package nz.co.maveros.auto.ghost.configuration;

import java.io.File;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Functions just like PropertiesConfiguration, except that when trying to
 * retrieve a scalar value from an array or collection, the *last* element is
 * produced instead of the first.
 * 
 * This means that later attempts to set a property will override earlier uses,
 * instead of being hidden.
 * 
 * @author Darien Hager
 */
public class OverridePropertyConfiguration extends PropertiesConfiguration implements Configuration {
	
	public OverridePropertyConfiguration(URL url) throws ConfigurationException {
		super(url);
	}

	public OverridePropertyConfiguration(File file) throws ConfigurationException {
		super(file);
	}

	public OverridePropertyConfiguration(String fileName) throws ConfigurationException {
		super(fileName);
	}

	public OverridePropertyConfiguration() {
		super();
	}

	@Override
	protected Object resolveContainerStore(String key) {
		Object value = getProperty(key);
		if (value != null) {
			if (value instanceof Collection) {
				Collection collection = (Collection) value;
				Iterator i = collection.iterator();
				value = null;
				while (i.hasNext()) {
					// Leave with *last* value or null
					value = i.next();
				}
			} else if (value.getClass().isArray() && Array.getLength(value) > 0) {
				// Pull back *last* value
				value = Array.get(value, Array.getLength(value) - 1);
			}
		}

		return value;
	}
}
