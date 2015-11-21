package javapractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcPractice {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver registed");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","jdbc");
		System.out.println("connection created");
		Statement st=con.createStatement();
		System.out.println("statement created");
		st.executeUpdate("insert into dep values(50,60)");
		System.out.println("values inserted");
		con.close();
		System.out.println("connection closed");
	}

}
