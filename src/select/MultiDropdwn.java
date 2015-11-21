package select;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;

public class MultiDropdwn {

	public static void main(String[] args) {
		ProfilesIni pr =new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("myprofile");
		FirefoxDriver driver=new FirefoxDriver(fp);
		driver.get("http://newtours.demoaut.com/mercuryregister.php?osCsid=7bff79a9d11ea682955f7639fb7b1e19");
		WebElement drop=driver.findElement(By.name("country"));
		Select sel=new Select(drop);
		sel.selectByIndex(1);
		sel.selectByIndex(2);
		sel.selectByValue("7");
		

	}

}
