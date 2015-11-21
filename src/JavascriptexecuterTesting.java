import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavascriptexecuterTesting {
	File scr;
	FirefoxDriver driver;
    @BeforeMethod
    public void setup()
    {
	ProfilesIni pr =new ProfilesIni();
	FirefoxProfile fp=pr.getProfile("myprofile");
	driver=new FirefoxDriver(fp);
	driver.get("http://www.google.co.in");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void javascriptTesting() throws IOException
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("alert('hello');");
    	scr= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr,new File("C:\\Users\\sai naresh\\Desktop\\withalert.jpg"));
    	alertHandle();
    	
    }
    public void alertHandle()
    {
    	try
    	{
    		Alert alert=driver.switchTo().alert();
    		
    		alert.accept();
    		
    		System.out.print("the alert is captured");
    		scr= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		FileUtils.copyFile(scr,new File("C:\\Users\\sai naresh\\Desktop\\afteralert.jpg"));
    	}
    	catch(Exception e)
    	{
    		System.out.print("the alert is not captured");
    	}
    }
}

