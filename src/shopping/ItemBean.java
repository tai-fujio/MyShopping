package shopping;

import java.io.Serializable;

public class ItemBean implements Serializable {

	private String id;
	private String name;
	private int price;
	private int quantity;

	public ItemBean() {
		this.id = "";
		this.name = "";
		this.price = 0;
		this.quantity = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
