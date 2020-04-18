package shopping;

import java.io.Serializable;

public class StockBean implements Serializable {

	private String item_id;
	private int quantity;

	public StockBean() {
		this.item_id = "";
		this.quantity = 0;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
