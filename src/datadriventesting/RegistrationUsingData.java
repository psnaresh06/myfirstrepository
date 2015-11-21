package datadriventesting;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationUsingData {
	FirefoxDriver driver;
	@BeforeMethod
 public void setup()
 {
	ProfilesIni pr=new ProfilesIni();
	FirefoxProfile fp=pr.getProfile("myprofile");
	FirefoxDriver driver=new FirefoxDriver(fp);
	driver.get("http://newtours.demoaut.com/");
	driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
 }
	@Test
	public void registerData() {
		
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")).sendKeys("hi");
		/*FileInputStream f=new FileInputStream("D:\\selinium practice\\Qedge\\bin\\com\\qedge\\excelfiles\\registration.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		Iterator<Row> row=ws.iterator();
		row.next();
		while(row.hasNext())
			
		{
			Row r=row.next();
			
			
		}
		*/
		
		
	}
}
