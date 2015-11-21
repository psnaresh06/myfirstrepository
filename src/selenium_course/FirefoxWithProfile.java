package selenium_course;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FirefoxWithProfile {

	public static void main(String[] args) {
		ProfilesIni pr= new ProfilesIni();
		FirefoxProfile fp = new FirefoxProfile();
		fp=pr.getProfile("myprofile");
		FirefoxDriver driver = new FirefoxDriver(fp);
		driver.get("http://google.com");
		
		
	}

}
