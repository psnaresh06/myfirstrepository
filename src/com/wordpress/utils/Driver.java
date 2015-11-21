package com.wordpress.utils;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Driver {
	public WebDriver driver=null;
	
	public void setup() 
	{try{

driver=new FirefoxDriver();
		driver.get("https://wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F");
	
	}
	catch(Exception e){
	System.out.println("driver not working");	
	}
	}
	
}
