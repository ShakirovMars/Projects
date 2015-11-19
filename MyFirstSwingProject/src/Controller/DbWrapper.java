package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbWrapper {
	
	public static Connection DBConnection() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String server = "localhost\\sqlexpress";
			int port = 1433;
			String user = "sa"; // Sql server username
			String password = "mars1996";
			String database = "Products";

			String jdbcUrl = "jdbc:sqlserver://" + server + ":" + port + ";user=" + user + ";password=" + password
					+ ";databaseName=" + database + "";

			con = DriverManager.getConnection(jdbcUrl);
			

		} catch (Exception ex) {
			System.out.println("Error : " + ex);
		}
		return con;
	}
}
