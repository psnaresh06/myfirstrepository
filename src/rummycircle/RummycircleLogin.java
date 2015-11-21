package rummycircle;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.Test;



public class RummycircleLogin {
	
	@Test
	public void rummycircleLogin() throws MalformedURLException
	{ DesiredCapabilities cap=null;
		
		
		cap=DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.ANY);
	
		/*else if(b.contains("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);
		}*/
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get("https://www.rummycircle.com/");
	    driver.findElement(By.id("j_username")).sendKeys("trendzstar");
	    driver.findElement(By.id("fake_j_password")).sendKeys("dor.lfnfk;");
	    driver.findElement(By.id("login_submit")).click();
	    driver.findElement(By.xpath(".//*[@id='account_box']/div/div[13]")).click();
	    
	    driver.close();
	    driver.quit();
	    driver=null;
	 	System.out.println("passed");
	   
	    
	    
	}

}
