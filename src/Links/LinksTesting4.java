package Links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTesting4 {
	FirefoxDriver driver;
	@BeforeMethod
		 public void setup(){
		ProfilesIni pr= new ProfilesIni();
		FirefoxProfile fp = new FirefoxProfile();
		fp=pr.getProfile("myprofile");
	     driver = new FirefoxDriver(fp);
		driver.get("http://www.pvrcinemas.com/");
		 }
		 @Test
		 public void radioTest()
		 {
		WebElement genral=driver.findElement(By.xpath("html/body/div[6]/div[1]/div[2]"));
		List<WebElement> links=genral.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++){
			System.out.println(links.get(i).getText());
			links.get(i).click();
			System.out.println(driver.getCurrentUrl());
			driver.navigate().back();
			genral=driver.findElement(By.xpath("html/body/div[6]/div[1]/div[2]"));
			links=genral.findElements(By.tagName("a"));
		}
		}
		
		
	

}
