package co.nuoya.JsonDB.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	//JDBC驱动及数据库URL
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/json";
	//DB用户名密码
	private static String user = "root";
	private static String password = "572165";
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,user,password);
	}
	
	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
