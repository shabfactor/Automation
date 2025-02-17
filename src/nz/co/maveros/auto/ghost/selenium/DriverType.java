package nz.co.maveros.auto.ghost.selenium;

public enum DriverType {
	Firefox,
	Chrome,
	IE;
	
	public static DriverType find(String driverType) {
		for (DriverType type : values()) {
			if (type.name().equalsIgnoreCase(driverType)) {
				return type;
			}
		}
		return Firefox;
	}
}
