package xloperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XlDropdownWrite {

	FirefoxDriver driver;
	@BeforeMethod
	 public void setup(){
	ProfilesIni pr= new ProfilesIni();
	FirefoxProfile fp = new FirefoxProfile();
	fp=pr.getProfile("myprofile");
    driver = new FirefoxDriver(fp);
	driver.get("http://newtours.demoaut.com/mercuryregister.php?osCsid=d0b230157778b2f3cb9b90e1793792cd");
	 }
	@Test
	public void xlDropdownTest() throws IOException
	{  FileInputStream f=new FileInputStream("C:\\Users\\sai naresh\\Desktop\\countrynames.xlsx");
	
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws =wb.getSheet("Sheet1");
		Row r=null;
		Cell c=null;
		WebElement drop=driver.findElement(By.name("country"));
		List<WebElement> dropdown=drop.findElements(By.tagName("option"));
		for(int i=0;i<dropdown.size();i++)
		{
			dropdown.get(i).click();
			String country=dropdown.get(i).getText();
			r=ws.createRow(i+1);
			c=r.createCell(0);
			c.setCellValue(country);
			c=r.createCell(1);
			c.setCellValue("the country is working");
			c=r.createCell(2);
			if(dropdown.get(i).isSelected())
			{
			
			c.setCellValue("passed");
			}
			else
			{
				c.setCellValue("failed");
			}
		}
			
		FileOutputStream f1=new FileOutputStream("C:\\Users\\sai naresh\\Desktop\\countrynames.xlsx");
		wb.write(f1);
		f1.close();
		
	}
}
