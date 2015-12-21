package data;

public class Customer {

	private String username;
	private String password;
	private boolean admin;
	

	public Customer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
