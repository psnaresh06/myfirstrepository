package cookiestest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CookiesTesting {
	FirefoxDriver driver;
	@BeforeMethod
	 public void setup(){
	ProfilesIni pr= new ProfilesIni();
	FirefoxProfile fp = new FirefoxProfile();
	fp=pr.getProfile("myprofile");
    driver = new FirefoxDriver(fp);
	driver.get("http://www.mirror.co.uk/");
	 }
	@Test
	public void cookiesTest()
	{
		Set<Cookie> mycookies=driver.manage().getCookies();
		System.out.println(mycookies.size());
		Iterator<Cookie> it=mycookies.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().getName()+"      "+it.next().getDomain());
		}
		driver.manage().deleteAllCookies();
		mycookies=driver.manage().getCookies();
		System.out.println(mycookies.size());
 	}
	
}
