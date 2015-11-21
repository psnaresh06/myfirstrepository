package gridpractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelTesting {
@DataProvider(parallel=true)
public Object[][] excelData() throws IOException{
	FileInputStream f=new FileInputStream("C:\\Users\\sai naresh\\Desktop\\exceldata.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(f);
	XSSFSheet ws=wb.getSheet("Sheet1");
	Row r=ws.getRow(0);
	int rowcount=ws.getLastRowNum();
	int colcount=r.getLastCellNum();
	Object[][] data=new Object[rowcount][colcount];
	for(int i=0;i<rowcount;i++)
	{
		for(int j=0;j<colcount;j++)
		{
		data[i][j]=ws.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return data;
	
}

@Test(dataProvider="excelData")
public void loginTest(String u,String p,String b) throws MalformedURLException 
{
	
	DesiredCapabilities cap=null;
	if(b.equals("firefox")){
		cap=DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
	}
	else if(b.equals("chrome")){
		cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
	}
	RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	driver.get("http://yahoomail.com");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys(u);
	driver.findElement(By.id("login-passwd")).sendKeys(p);
	driver.findElement(By.name("signin")).click();
	driver.close();
	driver.quit();
}

}
