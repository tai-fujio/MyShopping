package shopping;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

	public UserBean getUserData(String name, String password) {
		UserBean userbean = null;
		UserDao dao = null;
		ResultSet result = null;

		try {
			dao = new UserDao();
			result = dao.selectUser(name, password);
			userbean = new UserBean();
			userbean.setId(result.getString("id"));
			userbean.setName(result.getString("name"));
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			dao.close();
		}
		return userbean;
	}

}
