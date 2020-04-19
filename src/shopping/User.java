package shopping;

import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class User {

	public UserBean getUserData(String name, String password) {
		UserDao dao = null;
		Resultset result = null;

		try {
			dao = new UserDao();
			result = dao.selectUser(name, password);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			dao.close();
		}
		return result;
	}

}
