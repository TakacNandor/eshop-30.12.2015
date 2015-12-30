package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import data.Customer;
import starter.connect_DB;

public class CustomerController extends connect_DB {
	
	// private List<Customer> customerList = new ArrayList<>();

	public CustomerController(List<Customer> customerList) {
		super();
		// this.customerList = customerList;
	}

	public void addCustomer(String username, String password, int privilege) throws SQLException {
		boolean a = true;
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet result = null;
		try {
			stmt = conn.createStatement();
			result = stmt.executeQuery("select username from user");
			while (result.next()) {

				if (result.getString("username").equals(username)) {
					System.out.println("This user already exist.");
					a = false;
					break;
				}
			}
			if (a) {
				stmt.executeUpdate("INSERT INTO `user` (`id_user`, `username`, `password`, `privilege`) VALUES (NULL, '"
						+ username + "', '" + password + "', '" + privilege + "')");
			}

		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void searchByName(String username) throws SQLException {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet result = null;
		try {
			
			stmt = conn.createStatement();
			result = stmt.executeQuery("select username from user where username like '" + username + "%'");
			while (result.next()) {
				System.out.println("Search resut: ");
				System.out.print(result.getString("username"));
				System.out.println("\n");
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void deleteCustomer(String name) throws SQLException {
		Connection conn = getDBConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM user WHERE username='" + name + "';");

		}finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

}
