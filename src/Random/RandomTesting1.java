package Random;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class RandomTesting1 {

	public static void main(String[] args) throws Exception{
		HtmlUnitDriver driver =new HtmlUnitDriver(BrowserVersion.FIREFOX_38);
		driver.get("https://www.goair.in/");
		WebElement fromdrop=driver.findElement(By.id("departureCitysearchBoxUserControlCriteriaBox"));
		List<WebElement> dropdown=fromdrop.findElements(By.tagName("option"));
		int a=myRandomNumber(dropdown.size()-1);
		String  city=dropdown.get(a).getText();
		WebElement todrop=driver.findElement(By.id("toCitysearchBoxUserControlCriteriaBox"));
		if(todrop.getText().contains(city))
		{
			System.out.println(city+" is not working");
		}
		else
		{
			System.out.println(city+" is  working");
			
		}
		
	}


public static int myRandomNumber(int x)
{
	double b=Math.random()*x;
	int c =(int)b;
	return c;
}
}