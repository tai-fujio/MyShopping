package shopping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Item {

	public ArrayList<HistoryBean> getHistoryData(String id) {
		ArrayList<HistoryBean> historyList = new ArrayList<>();
		ItemDao dao = null;
		ResultSet result = null;

		try {
			dao = new ItemDao();
			result = dao.selectHistory(id);

			while (result.next()) {
				HistoryBean historybean = new HistoryBean();
				historybean.setItemId(result.getString("item_id"));
				historybean.setQuantity(result.getInt("quantity"));
				historybean.setItemName(result.getString("name"));
				historyList.add(historybean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dao.close();
		}
		return historyList;
	}

	public ArrayList<ItemBean> getItemList() {
		ItemDao dao = null;
		ResultSet result = null;
		ArrayList<ItemBean> itemList = new ArrayList<>();

		try {
			dao = new ItemDao();
			result = dao.selectItem();
			while (result.next()) {
				ItemBean itembean = new ItemBean();
				itembean.setId(result.getString("id"));
				itembean.setName(result.getString("name"));
				itembean.setPrice(result.getInt("price"));
				itembean.setQuantity(result.getInt("quantity"));
				itemList.add(itembean);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			dao.close();
		}
		return itemList;
	}
}
