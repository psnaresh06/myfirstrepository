package Links;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class LinksTesting2 {
	public static void main(String[] args) {
		ProfilesIni pr= new ProfilesIni();
		FirefoxProfile fp = new FirefoxProfile();
		fp=pr.getProfile("myprofile");
		FirefoxDriver driver = new FirefoxDriver(fp);
		driver.get("http://hdfcbank.com");
		List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=0;i<links.size();i++)
		{
			System.out.println(links.get(i).getText());
			
		}
		
		
		
		
		
		
		
		

}
}