package lib.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: August 25, 2014
 * Time: 12:30
 */
public class Playground {

	static String driverName = "com.mysql.jdbc.Driver";

	static String dbURL
			= "jdbc:mysql://114.215.127.136:3306/shrimp" +
			"?useUnicode=true&characterEncoding=UTF8";

	static String userName = "root";

	static String userPwd = "12121118Al";

	public static void main(String... args) {

		try {
			Class.forName(driverName);
			Connection dbConn = null;
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			Statement stat = dbConn.createStatement();
			boolean result = stat.execute("desc sh_user");

			ResultSet resultSet = stat.getResultSet();
			while(resultSet.next()) {
				System.out.print(resultSet.getString(1));
				System.out.print(resultSet.getString(2));
				System.out.print(resultSet.getString(3));
				System.out.print(resultSet.getString(4));
				System.out.println();
			}
			int a = 0;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
