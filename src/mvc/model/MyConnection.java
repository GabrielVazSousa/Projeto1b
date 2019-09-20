package mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	private static Connection conn = null;
	private static String mysql_url = System.getenv("mysql_url");
	private static String mysql_user = System.getenv("mysql_user");
	private static String mysql_password = System.getenv("mysql_password");
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = mysql_url + "/spring";
			conn = DriverManager.getConnection(url, mysql_user, mysql_password);
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
