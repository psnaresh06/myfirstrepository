package positivetesting;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

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

public class PositiveTesting {
	FirefoxDriver driver;
	@BeforeMethod
	public void setup()
	{
		ProfilesIni pr=new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("myprofile");
		driver=new FirefoxDriver(fp);
		driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	@Test
	public void positiveTest() throws IOException
	{
		FileInputStream f=new FileInputStream("C:\\Users\\sai naresh\\Desktop\\testdata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet2");
		Iterator<Row> row=ws.iterator();
		while(row.hasNext())
		{
			Row r=row.next();
			driver.findElement(By.id("Passwd")).sendKeys(r.getCell(0).getStringCellValue());	
		   driver.findElement(By.id("PasswdAgain")).click();
		  WebElement ajax= driver.findElement(By.id("errormsg_0_Passwd"));
		
		if(ajax.getText().isEmpty())
		{
			r.createCell(1).setCellValue("passed");
			
		}
		else
		{
			r.createCell(1).setCellValue("failed");
			
		}
		driver.findElement(By.id("Passwd")).click();
		driver.findElement(By.id("Passwd")).clear();
		}
		FileOutputStream f1=new FileOutputStream("C:\\Users\\sai naresh\\Desktop\\testdata.xlsx");
		wb.write(f1);
		f1.close();
		
	}
}
