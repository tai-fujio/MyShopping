package shopping;

import java.io.Serializable;

public class UserBean implements Serializable {

	private String id;
	private String password;
	private String name;
	private int age;

	public UserBean() {
		this.id = "";
		this.password = "";
		this.name = "";
		this.age = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
