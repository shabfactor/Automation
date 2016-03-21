package ghostobjects;

import helper.configuration.AutoConfig;
import helper.driver.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class GhostPrimaryObjectFixture {

	protected void userLogin(){
	Driver.get().navigate().to("http://localhost:2368/login"); 
	checkPageIsReady();
	WebElement username = Driver.get().findElement(By.xpath("//input[contains(@type,'email')]"));
	username.sendKeys(AutoConfig.getInstance().getUserName());
	WebElement password = Driver.get().findElement(By.xpath("//input[contains(@type,'password')]"));
	password.sendKeys(AutoConfig.getInstance().getPassword());
	WebElement signin = Driver.get().findElement(By.xpath("//button[contains(@class,'login btn')]"));
	signin.click();

}
	public void checkPageIsReady() {
		  
		  JavascriptExecutor js = (JavascriptExecutor)Driver.get();
		  
		  
		  //Initially bellow given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		   System.out.println("Page Is loaded.");
		   return; 
		  } 
		  
		  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		  for (int i=0; i<25; i++){ 
		   try {
		    Thread.sleep(1000);
		    }catch (InterruptedException e) {} 
		   //To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		    break; 
		   }   
		}
	  }
	}

