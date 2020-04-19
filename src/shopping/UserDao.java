package shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	private Connection connection = null;
	private ResultSet result = null;
	private PreparedStatement prepared = null;

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
