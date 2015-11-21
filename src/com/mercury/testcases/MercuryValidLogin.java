/**
 * 
 */
package com.mercury.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mercury.pages.LoginPage;

/**
 * @author sai naresh
 *
 */
public class MercuryValidLogin {
@Parameters("browser")
	@Test
	public void verifyValidLogin(String b) throws MalformedURLException
	{
		DesiredCapabilities cap=null;
		if(b.equals("firefox")){
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);	
		}
		else if(b.equals("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);
		}
		
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		
		driver.get("http://newtours.demoaut.com");
		LoginPage login=new LoginPage(driver);
		login.typeUserName("sai");
		login.typeUserPassword("pass@123");
		login.clickOnLoginButton();
	}
	
}
