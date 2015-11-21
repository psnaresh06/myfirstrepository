package calander;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalanderTesting {

	FirefoxDriver driver;
	@BeforeMethod
	 public void setup(){
	ProfilesIni pr= new ProfilesIni();
	FirefoxProfile fp = new FirefoxProfile();
	fp=pr.getProfile("myprofile");
    driver = new FirefoxDriver(fp);
	driver.get("http://www.makemytrip.com/");
	 }
	@Test
	public void calanderTest()
	{
		driver.findElement(By.className("radio_state")).click();
		driver.findElement(By.id("from_typeahead1")).sendKeys("Hyderabad, India (HYD)");
		driver.findElement(By.id("to_typeahead1")).sendKeys("New Delhi, India (DEL)");
		driver.findElement(By.id("start_date_sec")).click();
		//date of journey
		String doj="6/08/2016";
		String[] a=doj.split("/");
		String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
	    int x=Integer.parseInt(a[1]);
	    String month=months[x-1];
	    String date=a[0];
	    String year=a[2];
	    //class ofthe year on left calender
	    String calyear=driver.findElement(By.className("ui-datepicker-year")).getText();
	    while(!calyear.equals(year))
	    {
	    	driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]/div/a/span")).click();
	    	calyear=driver.findElement(By.className("ui-datepicker-year")).getText();
	    }
	    //class of the month in left calender
	  String calmonth=  driver.findElement(By.className("ui-datepicker-month")).getText();
	  while(!calmonth.equals(month))
	  {
		  driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]/div/a/span")).click();
		  calmonth= driver.findElement(By.className("ui-datepicker-month")).getText();
	  }
	  //xpath of total calender
	  WebElement datetable=driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]"));
	  boolean flag=false;
	  List<WebElement> row=datetable.findElements(By.tagName("tr"));
	  for(int i=0;i<row.size();i++)
	  {
		  List<WebElement> cols=row.get(i).findElements(By.tagName("td"));
	 for(int j=0;j<cols.size();j++)
	 {
		 if(cols.get(j).getText().equals(date))
		 {
			 cols.get(j).click();
			 flag=true;
			 break;
		 }
	 }
	 if(flag==true)
	 {
		 break;
	 }
	 
	  }
	}
}
	
