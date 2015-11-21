package xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XpathCreation {
	FirefoxDriver driver;
	@BeforeMethod
	 public void setup(){
	ProfilesIni pr= new ProfilesIni();
	FirefoxProfile fp = new FirefoxProfile();
	fp=pr.getProfile("myprofile");
    driver = new FirefoxDriver(fp);
	driver.get("https://www.google.co.in/search?q=googlenews&ie=utf-8&oe=utf-8&gws_rd=cr&ei=89kKVs-HFMi6uASQqpzgAw#tbm=nws&q=bahubali");
	 }
	@Test
	public void xpathTesting()
	{
		driver.findElement(By.xpath("//div[@class='ts _V6c _Zmc _XO _knc _d7c']/div/h3/a")).click();
	}
}
