package capcha;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class CapchaTesting {

	public static void main(String[] args) {
		ProfilesIni pr =new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("myprofile");
		FirefoxDriver driver=new FirefoxDriver(fp);
		driver.get("http://www.harvard.edu/feedback");
	String x=driver.findElement(By.className("field-prefix")).getText();
		String[] a=x.split(" ");
		int i=Integer.parseInt(a[0]);
		int j=Integer.parseInt(a[2]);
		int k=i+j;
		String b=Integer.toString(k);
		driver.findElement(By.id("edit-captcha-response")).sendKeys(b);
		
		
		

	}

}
