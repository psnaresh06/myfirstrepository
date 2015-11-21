package ajaxes;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
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

public class AjaxTesting {
	FirefoxDriver driver;
    @BeforeMethod
    public void setup()
    {
	ProfilesIni pr =new ProfilesIni();
	FirefoxProfile fp=pr.getProfile("myprofile");
	driver=new FirefoxDriver(fp);
	driver.get("http://www.google.co.in");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void ajaxTesting() throws InterruptedException, IOException
    {
    	FileInputStream f=new FileInputStream("C:\\Users\\sai naresh\\Desktop\\myworkbook.xlsx");
    	XSSFWorkbook wb=new XSSFWorkbook(f);
    	XSSFSheet ws=wb.getSheet("Sheet1");
    	
    	driver.findElement(By.name("q")).sendKeys("chiranjeevi");
    	WebElement block=driver.findElement(By.className("sbdd_b"));
    List<WebElement> ajax=block.findElements(By.xpath("//*[starts-with(@id,'sbse')]/div[2]"));
    System.out.println(ajax.size());
    Row r=ws.createRow(0);
    for(int i=0;i<ajax.size();i++)
    {
    	r.createCell(i).setCellValue(ajax.get(i).getText());
    	 System.out.println(ajax.get(i).getText());
    	
    }
    FileOutputStream f1=new FileOutputStream("C:\\Users\\sai naresh\\Desktop\\myworkbook.xlsx");
    	wb.write(f1);
    	f1.close();
    }
    
    
}
