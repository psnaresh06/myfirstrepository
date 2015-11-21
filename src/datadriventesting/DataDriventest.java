package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataDriventest {
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
	public void dataDriventest() throws IOException
	{
		FileInputStream f=new FileInputStream("D:\\selinium practice\\Qedge\\src\\com\\qedge\\excelfiles\\links.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Iterator<Row> row=ws.iterator();
		row.next();
		while(row.hasNext())
		{
		Row r=row.next();
		String linkname=r.getCell(0).getStringCellValue();
		try{
		driver.findElement(By.linkText(linkname)).click();
		String acturl=driver.getCurrentUrl();
		String expurl=r.getCell(1).getStringCellValue();
		r.createCell(2).setCellValue(acturl);
		if(acturl.contains(expurl))
		{
			r.createCell(3).setCellValue("passed");
			
		}
		else
		{
			r.createCell(3).setCellValue("failed");
			File scr= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr,new File("D:\\selinium practice\\Qedge\\src\\com\\qedge\\screenshots\\"+linkname+".jpg"));
		}
		driver.navigate().back();
		}
		catch(Exception e)
		{
			r.createCell(3).setCellValue("link not found");
			File scr= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr,new File("D:\\selinium practice\\Qedge\\src\\com\\qedge\\screenshots\\"+linkname+".jpg"));
		}
		}
		FileOutputStream f1=new FileOutputStream("D:\\selinium practice\\Qedge\\src\\com\\qedge\\resultexcelfiles\\resultlinks.xlsx");
		wb.write(f1);
		f1.close();
	}

}
