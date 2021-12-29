package WinBuilder;

import java.sql.*;

public class DbConnection {
	public Connection getDbConnection() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String connectionString = "jdbc:mysql://localhost:3306/student_sytem";
			String db_username = "root";
			String db_password = "";
			
			Connection con = DriverManager.getConnection(connectionString, db_username, db_password);
			return con;
		} catch(SQLException ex) {
			throw ex;
		}
	}
}
