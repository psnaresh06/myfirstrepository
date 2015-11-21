package gridpractice;




import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTesting {
	@Test
	public void logintTest() throws MalformedURLException
	{
		
		DesiredCapabilities cap=null;
		cap=DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("http://yahoomail.com");
		driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys("saikrishna");
		driver.findElement(By.id("login-passwd")).sendKeys("pass@123");
		driver.findElement(By.name("signin")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.quit();
		
		
	}

}

