package selenium_course;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class LinksTesting1 {

	public static void main(String[] args) {
		ProfilesIni pr =new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("myprofile");
		FirefoxDriver dr= new FirefoxDriver(fp);
		dr.get("http://bing.com");
	String eurl= dr.findElement(By.linkText("VIDEOS")).getAttribute("href");
	dr.findElement(By.linkText("VIDEOS")).click();
	String aurl =dr.getCurrentUrl();
	
		if(aurl.contains(eurl))
		{
			System.out.println("link is working");
		}
		else
		{
			System.out.println("link not working");
		}
		
		

	}

}
