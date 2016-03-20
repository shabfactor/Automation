package ghostobjects;

import helper.driver.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GhostPrimaryObjectFixture {

	protected void userLogin(){
	Driver.get().navigate().to("http://localhost:2368/login"); 
	WebElement username = Driver.get().findElement(By.xpath("//input[contains(@type,'email')]"));
	username.sendKeys("shaibal929@gmail.com");
	WebElement password = Driver.get().findElement(By.xpath("//input[contains(@type,'password')]"));
	password.sendKeys("Hidden_29");
	WebElement signin = Driver.get().findElement(By.xpath("//button[contains(@class,'login btn')]"));
	signin.click();

}
}
