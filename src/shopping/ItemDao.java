package shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDao {

	private Connection connection = null;
	private ResultSet result = null;
	private PreparedStatement prepared = null;

	public ResultSet SelectHistory(String id) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Shopping", "root", "user2");
			prepared = connection.prepareStatement(
					"select history.item_id,history.quantity,item.name from history inner join user on history.user_id = ? inner join item on history.item_id = item.id;");
			prepared.setString(1, id);
			result = prepared.executeQuery();

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		return result;

	}

	public void updateStock(String itemId, int quantity) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample",
					"root",
					"user2");
			prepared = connection.prepareStatement("update stock quantity -= ? where item_id = ? ");
			prepared.setInt(1, quantity);
			prepared.setString(2, itemId);
			prepared.executeUpdate();

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}

	}

	public void updateHistory(String userid, String itemId, int quantity) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample",
					"root",
					"user2");
			prepared = connection.prepareStatement("insert into history (user_id, item_id, quantity) values(?, ?, ?)");
			prepared.setString(1, userid);
			prepared.setString(2, itemId);
			prepared.setInt(3, quantity);
			prepared.executeUpdate();

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}

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
