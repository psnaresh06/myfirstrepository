package Links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class ValidateAllLinks {
	public static void main(String[] ar){
		ProfilesIni pr= new ProfilesIni();
		FirefoxProfile fp =pr.getProfile("myprofile");
		FirefoxDriver driver=new FirefoxDriver(fp);
		driver.get("http://newtours.demoaut.com/");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=0;i<links.size();i++){
			if(links.get(i).isDisplayed())
			{
				String lname=links.get(i).getText();
				String expurl=links.get(i).getAttribute("href");
				links.get(i).click();
				String acurl=driver.getCurrentUrl();
				if(acurl.contains(expurl))
				{
					System.out.println(lname +"  is working properly");
					
				}
				else
				{
					System.out.println(lname +"is not working properly");
				}
				driver.navigate().back();
				links=driver.findElements(By.tagName("a"));
				
				
				
				
			}
			
		}
		
		
		
		
		
	}

}
