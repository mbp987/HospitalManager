package app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public Connection Connection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "mbp987");
		
	}
}
