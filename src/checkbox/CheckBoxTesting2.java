package checkbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTesting2 {

	FirefoxDriver driver;
	@BeforeMethod
	 public void setup(){
	ProfilesIni pr= new ProfilesIni();
	FirefoxProfile fp = new FirefoxProfile();
	fp=pr.getProfile("myprofile");
    driver = new FirefoxDriver(fp);
	driver.get("http://www.echoecho.com/htmlforms09.htm");
	 }
	@Test
	public void checkBox()
	{
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
	    for(int i=0;i<check.size();i++)
	    {
	    	if(!check.get(i).isSelected()){
	    	check.get(i).click();
	    	}
	    	System.out.println(check.get(i).getAttribute("value")+"-----"+check.get(i).getAttribute("checked"));
	    	}
	}
}
