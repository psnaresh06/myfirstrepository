package background;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class BackgroundTesting1 {

	public static void main(String[] args) {
		HtmlUnitDriver driver=new HtmlUnitDriver(BrowserVersion.FIREFOX_38);
		driver.get("http://google.com");
		driver.findElement(By.className("gb_P")).click();
		String str=driver.getCurrentUrl();
		System.out.println(str);
		

	}

}
