package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import data.Customer;

public class CustomerController {

	private List<Customer> customerList = new ArrayList<>();

	public CustomerController(List<Customer> customerList) {
		super();
		this.customerList = customerList;
	}


	public void addCustomer(String username, String password) {
		boolean a = true;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop_db?user=root&password=");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select username from user");
			while (result.next()) {

				if (result.getString("username").equals(username)) {
					System.out.println("This user already exist.");
					a = false;
					break;
				}
			}
			if (a) {
				statement.executeUpdate("INSERT INTO `user` (`id_user`, `username`, `password`) VALUES (NULL, '"
						+ username + "', '" + password + "')");
			}

			connection.close();
		} catch (SQLException sx) {
			System.out.println("SQLException: " + sx.getMessage());
			System.out.println("SQLState: " + sx.getSQLState());
			System.out.println("VendorError: " + sx.getErrorCode());
		}

	}

	public Customer searchByName(String username) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop_db?user=root&password=");
			Statement statement = connection.createStatement();
			ResultSet result = statement
					.executeQuery("select username from user where username like '" + username + "%'");
			while (result.next()) {
				System.out.println("Search resut: ");
				System.out.print(result.getString("username"));
				System.out.println("\n");

			}

			connection.close();
		} catch (SQLException sx) {
			System.out.println("SQLException: " + sx.getMessage());
			System.out.println("SQLState: " + sx.getSQLState());
			System.out.println("VendorError: " + sx.getErrorCode());
		}

		return null;
	}

	public void deleteCustomer(String name) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop_db?user=root&password=");
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM user WHERE username='" + name + "';");

			connection.close();
		} catch (SQLException sx) {
			System.out.println("SQLException: " + sx.getMessage());
			System.out.println("SQLState: " + sx.getSQLState());
			System.out.println("VendorError: " + sx.getErrorCode());
		}
	}

}
