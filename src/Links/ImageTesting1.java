package Links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class ImageTesting1 {
	public static void main(String[] args) {
		ProfilesIni pr= new ProfilesIni();
		FirefoxProfile fp = new FirefoxProfile();
		fp=pr.getProfile("myprofile");
		FirefoxDriver driver = new FirefoxDriver(fp);
		driver.get("http://www.pvrcinemas.com/");	
	  List<WebElement> imgs=driver.findElements(By.tagName("img"));
	  System.out.println(imgs.size());
		for(int i=0;i<imgs.size();i++){
			System.out.println(imgs.get(i).getAttribute("src"));
		
		}
}
}