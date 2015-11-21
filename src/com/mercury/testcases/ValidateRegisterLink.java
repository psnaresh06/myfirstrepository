package com.mercury.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.mercury.pages.LoginPage;

public class ValidateRegisterLink {
	@Test
	public void validateRegisterLink() throws MalformedURLException
	{
		DesiredCapabilities cap=null;
		
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);	
		
		
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		
		driver.get("http://newtours.demoaut.com");
		LoginPage login=new LoginPage(driver);
		login.clickOnRegisterLink();
		
	}

}
