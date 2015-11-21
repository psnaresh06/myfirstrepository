package javapractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedPractice2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Connection con=null;
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("driver registed");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","jdbc");
	System.out.println("connection created");
	PreparedStatement pst=con.prepareStatement("select * from dep");
	System.out.println("statement created");
	ResultSet rs=pst.executeQuery();
	System.out.println("query executed");
	while(rs.next())
	{
		System.out.print(rs.getInt(1)+ "\t");
		System.out.println(rs.getInt(2)+ "\t");
	}
con.close();
System.out.println("connection close");
	}

}
