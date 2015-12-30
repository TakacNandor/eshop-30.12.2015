package data;

public class Customer {

	private String username;
	private String password;
	private boolean privilege;
	

	public Customer(String username, String password, boolean privilege) {
		super();
		this.username = username;
		this.password = password;
		this.privilege = privilege;
		
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

	public boolean isPrivilege() {
		return privilege;
	}

	public void setPrivilege(boolean privilege) {
		this.privilege = privilege;
	}

	

}
