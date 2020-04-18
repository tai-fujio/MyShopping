package shopping;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class Item {

	public ArrayList<HistoryBean> getHistoryData(String id) {
		ArrayList<HistoryBean> historyList = new ArrayList<>();
		Item dao = null;
		Resultset result = null;

		try {
			dao = new ItemDao();
			result = dao.selectHistory(id);

			while (result.next()) {
				HistoryBean hisotybean = new HistoryBean();
				bean.setItemId(result.getString("item_id"));
				bean.setItemName(result.getInt("quantity"));
				bean.setItemName(result.getString("name"));
				historyList.add(historybean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.close();
		}
		return historyList;
	}
}
