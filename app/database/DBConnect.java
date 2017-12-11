package app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public Connection getConnection() throws SQLException{
		//return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "mbp987");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "mbp987");
        return conn;
		
	}
}
