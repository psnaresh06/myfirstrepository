package waittesting;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitTesting1 {
FirefoxDriver driver;
	@BeforeMethod
public void setup(){
	ProfilesIni pr=new ProfilesIni();
	FirefoxProfile fp=pr.getProfile("myprofile");
	 driver=new FirefoxDriver(fp);
driver.get("http://www.flipkart.com/");	

}
	@Test
public void waitTest()
{
	WebDriverWait mywait=new WebDriverWait(driver, 50);
	mywait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='b-tab0-content']/a/img")));
mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='b-tab3-content']/a/img"))).click();
}
}
