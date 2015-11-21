package autoit;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;



public class DownloadAutoit {
	@Test
	public void autoitTest() throws IOException, AWTException
	{
		
		ProfilesIni pr=new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("myprofile");
		FirefoxDriver driver=new FirefoxDriver(fp);
		driver.get("http://www.seleniumhq.org/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='menu_download']/a")).click();
		driver.findElement(By.xpath(".//*[@id='mainContent']/p[3]/a")).click();
		Robot r=new Robot();
		r.keyPress(1);
		
		}

}
