package practicetestcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registerlink {
	FirefoxDriver driver;
	@BeforeMethod
	 public void setup(){
	ProfilesIni pr= new ProfilesIni();
	FirefoxProfile fp = new FirefoxProfile();
	fp=pr.getProfile("myprofile");
    driver = new FirefoxDriver(fp);
	driver.get("http://newtours.demoaut.com/");
	 }
	@Test
	public void registerTest() throws IOException
	{
		FileInputStream f=new FileInputStream("D:\\selinium practice\\Qedge\\bin\\com\\qedge\\excelfiles\\registration.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
		Iterator<Row> row=ws.iterator();
		row.next();
		while(row.hasNext())
		{
			Row r=row.next();
			driver.findElement(By.name("firstName")).sendKeys(r.getCell(0).getStringCellValue());
		}
		
		
	}
}
