package ecomproj;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
	private static Connection conn=null;
	public static Connection getConnection()
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_proj","root","R@ms7030646480");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

		
	}
}
