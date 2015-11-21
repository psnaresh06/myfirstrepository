package xpaths;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class XpathTesting {
	@Test
	public void xpathTest()
	{
		
		ProfilesIni pr=new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("myprofile");
		FirefoxDriver driver =new FirefoxDriver(fp);
		driver.get("http://www.cinejosh.com/");
	
		
	driver.findElement(By.xpath("//ul[@class='items']/li[1]/a")).click();
	
		
		
	}

}
