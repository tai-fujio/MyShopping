package shopping;

import java.io.Serializable;

public class HistoryBean implements Serializable {
	private String itemName;
	private String userId;
	private String itemId;
	private int quantity;

	public HistoryBean() {
		this.itemName = "";
		this.userId = "";
		this.itemId = "";
		this.quantity = 0;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
