package dropdown;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class DropDownTesting3 {

	public static void main(String[] args) {
		ProfilesIni pr =new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("myprofile");
		FirefoxDriver driver=new FirefoxDriver(fp);
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
		WebElement drop=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select"));
		List<WebElement> dropdown=drop.findElements(By.tagName("option"));
        System.out.println(dropdown.size());
		for(int i=0;i<dropdown.size();i++){
			dropdown.get(i).click();
			if(dropdown.get(i).isSelected()){
				System.out.println(dropdown.get(i).getText()+ "is active");
			}
		}

	}

}
