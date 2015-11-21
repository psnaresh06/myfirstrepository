package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class DropDownTestin4 {

	public static void main(String[] args) {
		ProfilesIni pr =new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("myprofile");
		FirefoxDriver driver=new FirefoxDriver(fp);
		driver.get("https://www.goair.in/");
		WebElement drop=driver.findElement(By.id("departureCitysearchBoxUserControlCriteriaBox"));
		List<WebElement> fdrop=drop.findElements(By.tagName("option"));
		
		for(int i=1;i<fdrop.size();i++)
		{
			fdrop.get(i).click();
			String str=fdrop.get(i).getText();
			WebElement tdrop=driver.findElement(By.id("toCitysearchBoxUserControlCriteriaBox"));
			if(tdrop.getText().contains(str))
			{
				System.out.println(str +" not working properly");
			}
			else
			{
				System.out.println(str + " the dropdown working properly");
			}
			
		}

	}

}
