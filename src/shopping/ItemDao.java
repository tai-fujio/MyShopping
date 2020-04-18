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
					"select history.user_id from history inner join user on history.user_id = ? inner join item on history.item_id = item.id;");
			prepared.setString(1, id);
			result = prepared.executeQuery();

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		return result;

	}
}
