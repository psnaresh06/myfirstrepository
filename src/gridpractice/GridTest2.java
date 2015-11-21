package gridpractice;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridTest2 {
	
	@Parameters("browser")
	@Test
	public void dropdownTest(String b) throws IOException
	{
		DesiredCapabilities cap=null;
		if(b.equals("firefox"))
		{
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
		}
		else if(b.equals("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}
		
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("http://www.google.co.in");
    	driver.findElement(By.name("q")).sendKeys("chiranjeevi");
    	WebElement block=driver.findElement(By.className("sbdd_b"));
    List<WebElement> ajax=block.findElements(By.xpath("//*[starts-with(@id,'sbse')]/div[2]"));
    System.out.println(ajax.size());
    
    for(int i=0;i<ajax.size();i++)
    {
    	
    	 System.out.println(ajax.get(i).getText());
    	
    }
    driver.close();
	
		}
}
	



		