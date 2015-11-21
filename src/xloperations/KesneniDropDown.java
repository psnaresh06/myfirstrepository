package xloperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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

public class KesneniDropDown {
	FirefoxDriver driver;
	@BeforeMethod
	 public void setup(){
	ProfilesIni pr= new ProfilesIni();
	FirefoxProfile fp = new FirefoxProfile();
	fp=pr.getProfile("myprofile");
    driver = new FirefoxDriver(fp);
	driver.get("http://www.kesinenitravels.com/index.aspx");
	 }
	@Test
	public void kesedropTest() throws IOException, InterruptedException
	{
		FileInputStream f=new FileInputStream("D:\\selinium practice\\Qedge\\src\\com\\qedge\\resultexcelfiles\\kesdrop.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		driver.findElement(By.id("ctl00_cpEndUserMain_ucSearchRoute_rbtnList_1")).click();
		
		WebElement fromdrop=driver.findElement(By.id("ctl00_cpEndUserMain_ucSearchRoute_ddlSource"));
		List<WebElement> fromdropdown= fromdrop.findElements(By.tagName("option"));
		for(int i=0;i<fromdropdown.size();i++ )
		{
			fromdropdown.get(i).click();
			Thread.sleep(1000);
			String fcity=fromdropdown.get(i).getText();
			Row r=ws.createRow(i);
			r.createCell(0).setCellValue(fcity);
		WebElement todrop=	driver.findElement(By.id("ctl00_cpEndUserMain_ucSearchRoute_ddlDestination"));
		List<WebElement> todropdown=todrop.findElements(By.tagName("option"));
		for(int j=0;j<todropdown.size();j++)
		{      
			todropdown.get(j).click();
			String tocity=todropdown.get(j).getText();
		r.createCell(1).setCellValue(tocity);
		}
		if(todrop.getText().contains(fcity))
			{
				r.createCell(2).setCellValue("failed");
			}
		else
		{
			r.createCell(2).setCellValue("passed");
		}
		
		}
		FileOutputStream f1=new FileOutputStream("D:\\selinium practice\\Qedge\\src\\com\\qedge\\resultexcelfiles\\kesdrop.xlsx");
		wb.write(f1);
		f1.close();	
	}
}
