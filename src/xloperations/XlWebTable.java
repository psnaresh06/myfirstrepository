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

public class XlWebTable {
	FirefoxDriver driver;

	@BeforeMethod
	 public void setup(){
	ProfilesIni pr= new ProfilesIni();
	FirefoxProfile fp = new FirefoxProfile();
	fp=pr.getProfile("myprofile");
   driver = new FirefoxDriver(fp);
	driver.get("http://www.timeanddate.com/worldclock/");
	 }
	@Test
	public void xlWebTableTest() throws IOException
	{   FileInputStream f=new FileInputStream("C:\\Users\\sai naresh\\Desktop\\webtable.xlsx");
	    XSSFWorkbook wb=new XSSFWorkbook(f);
	    XSSFSheet ws=wb.getSheet("Sheet1");
	    Row r=null;
	    Cell c=null;
		WebElement table=driver.findElement(By.xpath("html/body/div[1]/div[7]/section[2]/div[1]"));
		List<WebElement> row=table.findElements(By.tagName("tr"));
		for(int i=0;i<row.size();i++)
		{  r = ws.createRow(i);
		    
			List<WebElement> cols=row.get(i).findElements(By.tagName("td"));
			for(int j=0;j<cols.size();j++)
			{
				c=r.createCell(j);
				c.setCellValue(cols.get(j).getText());
			}
		}
	FileOutputStream f1=new FileOutputStream("C:\\Users\\sai naresh\\Desktop\\webtable.xlsx");
	wb.write(f1);
	f1.close();
	}
	
}
