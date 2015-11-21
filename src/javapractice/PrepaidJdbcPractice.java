package javapractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepaidJdbcPractice {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Connection con=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","jdbc");
		String query="insert into dep values(?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1,30);
		pst.setInt(2, 60);
		pst.executeUpdate();
		con.close();
		
	}
}
