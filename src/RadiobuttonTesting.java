import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadiobuttonTesting {
	
	FirefoxDriver driver;
	@BeforeMethod
	 public void setup(){
	ProfilesIni pr= new ProfilesIni();
	FirefoxProfile fp = new FirefoxProfile();
	fp=pr.getProfile("myprofile");
    driver = new FirefoxDriver(fp);
	driver.get("http://www.echoecho.com/htmlforms10.htm");
	 }

	 @Test
	 public void radioButtontest()
	 {
	WebElement radio=driver.findElement(By.xpath("html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));	 
	List<WebElement> radiobut =radio.findElements(By.name("group1"));
	for(int i=0;i<radiobut.size();i++)

	{
		radiobut.get(i).click();
		for(int j=0;j<radiobut.size();j++)
		{
	System.out.println(radiobut.get(j).getAttribute("value")+"---"+ radiobut.get(j).getAttribute("checked"));	
	}
		System.out.println("******************----------#############");
	}
}
}
