package shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	private Connection connection = null;
	private ResultSet result = null;
	private PreparedStatement prepared = null;

	public ResultSet selectUser(String name, String password) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "root", "user2");
			prepared = connection.prepareStatement("select name,id from user where name = ? and password = ?");
			result = prepared.executeQuery();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		return result;
	}

	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (result != null) {
				result.close();
			}
			if (prepared != null) {
				prepared.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}
