package jdbctesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JdbcTesting1 {
	FirefoxDriver driver;
	@BeforeMethod
	public void setup()
	{
		ProfilesIni pr=new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("myprofile");
		driver=new FirefoxDriver(fp);
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.linkText("REGISTER")).click();
			
	}
	@Test
	public void jdbcTest() throws ClassNotFoundException, SQLException{
		Connection con=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver registed");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","jdbc");
		System.out.println("connection created");
		PreparedStatement pst=con.prepareStatement("select * from register");
		
		System.out.println("statement created");
		ResultSet rs=pst.executeQuery();
		System.out.println("query executed");
		while(rs.next())
		{
			driver.findElement(By.name("firstName")).sendKeys(rs.getString(1));
			driver.findElement(By.name("lastName")).sendKeys(rs.getString(2));
			driver.findElement(By.name("phone")).sendKeys(rs.getString(3));
			driver.findElement(By.id("userName")).sendKeys(rs.getString(4));
			driver.findElement(By.name("address1")).sendKeys(rs.getString(5));
			driver.findElement(By.name("city")).sendKeys(rs.getString(6));
			driver.findElement(By.name("state")).sendKeys(rs.getString(7));
			driver.findElement(By.name("postalCode")).sendKeys(rs.getString(8));
			driver.findElement(By.name("country")).sendKeys(rs.getString(9));
			driver.findElement(By.name("email")).sendKeys(rs.getString(10));
			driver.findElement(By.name("password")).sendKeys(rs.getString(11));
			driver.findElement(By.name("confirmPassword")).sendKeys(rs.getString(12));
			driver.findElement(By.name("register")).click();			
			driver.navigate().back();
			
		}
		/* while(rs.next())
		 {
			 System.out.print(rs.getString(1)+"\t");
			 System.out.print(rs.getString(2)+"\t");
			 System.out.print(rs.getString(3)+"\t");
			 System.out.print(rs.getString(4)+"\t");
			 System.out.print(rs.getString(5)+"\t");
			 System.out.print(rs.getString(6)+"\t");
			 System.out.print(rs.getString(7)+"\t");
			 System.out.print(rs.getString(8)+"\t");
			 System.out.print(rs.getString(9)+"\t");
			 System.out.print(rs.getString(10)+"\t");
			 System.out.print(rs.getString(11)+"\t");
			 System.out.println(rs.getString(12));
			 
		 }
		*/
		con.close();
	}

}
