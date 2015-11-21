package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class DropdownTesting2 {

	public static void main(String[] args) {
		ProfilesIni pr =new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("myprofile");
		FirefoxDriver driver=new FirefoxDriver(fp);
		driver.get("http://www.amazon.in/");
		WebElement drop=driver.findElement(By.id("searchDropdownBox"));
	    List<WebElement> dropdown=drop.findElements(By.tagName("option"));
	    for(int i=0;i<dropdown.size();i++){
	    	System.out.println(dropdown.get(i).getText());
	    	
	    }
	    	
	}

}
