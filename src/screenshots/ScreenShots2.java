package screenshots;



import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class ScreenShots2 {

	public static void main(String[] args) throws IOException {
		ProfilesIni pr =new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("myprofile");
		FirefoxDriver driver=new FirefoxDriver(fp);
		driver.get("https://www.google.com");
		List<WebElement> links=driver.findElements(By.linkText("chiranjeevi"));
		if(links.size()==0)
		{
			File scr= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr,new File("second.jpg"));
			
		}
		else
		{
			driver.findElement(By.linkText("chiranjeevi")).click();
			
		}
		
	}

}
