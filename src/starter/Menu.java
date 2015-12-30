package starter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.CustomerController;
import Controller.OrderController;
import Controller.ProductController;
import account.Login;
import data.Customer;
import data.Order;
import data.Product;

public class Menu extends connect_DB {

	private List<Product> productList = new ArrayList<>();
	private List<Customer> customerList = new ArrayList<>();
	private List<Order> orderList = new ArrayList<>();

	ProductController myProducts = new ProductController(productList);
	CustomerController myCustomers = new CustomerController(customerList);
	OrderController myOrders = new OrderController(orderList);

	public Menu(List<Product> productList, List<Customer> customerList, List<Order> orderList) {
		/*
		 * this.productList = productList; this.orderList = orderList;
		 * this.customerList = customerList;
		 */
	}

	Login login = new Login();

	public void getMenu() throws Exception {
		try {
			Connection conn = getDBConnection();
			Statement stmt = null;
			ResultSet result = null;

			stmt = conn.createStatement();
			result = stmt.executeQuery(
					"SELECT user.privilege FROM user INNER JOIN loged_user ON user.id_user=loged_user.user_id;");

			while (result.next()) {

				if (result.getBoolean("privilege")) {
					getAdminMenu();
				} else {
					getCustomerMenu();
				}
			}

			result.close();
		} catch (SQLException sx) {
			System.out.println("SQLException: " + sx.getMessage());
			System.out.println("SQLState: " + sx.getSQLState());
			System.out.println("VendorError: " + sx.getErrorCode());
		}

	}

	public void getAdminMenu() throws Exception {

		System.out.println("Menu: ");
		System.out.println("1. Add product.");
		System.out.println("2. Remove product.");
		System.out.println("3. Show all products.");
		System.out.println("4. Update product.");
		System.out.println("5. Show product details.");

		System.out.println("6. Add user.");
		System.out.println("7. Remove user.");
		System.out.println("8. Search user by name.");

		System.out.println("9. Order a product.");
		System.out.println("0. Finish shopping.");
		System.out.println("Select your option.");
		menuOption();

	}

	public void getCustomerMenu() throws Exception {
		System.out.println("Menu: ");
		System.out.println("3. Show all products.");
		System.out.println("5. Show product details.");

		System.out.println("6. Create account.");
		System.out.println("8. Search user by name.");

		System.out.println("9. Order a product.");
		System.out.println("0. Finish shopping.");
		System.out.println("Select your option.");
		menuOption();
	}

	public void menuOption() throws Exception {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		int tmp = Integer.parseInt(input.nextLine());
		switch (tmp) {
		case 0:
			login.userLogout();
			System.out.println("Good bye.");
			break;

		case 1:
			System.out.println("Product name: ");
			String name = input.nextLine();

			System.out.println("Description: ");
			String desc = input.nextLine();

			System.out.println("Price: ");
			int price = input.nextInt();
			System.out.println("Count: ");
			int count = input.nextInt();
			myProducts.addProduct(name, desc, price, count);
			getAdminMenu();
			menuOption();

		case 2:
			myProducts.toString();
			System.out.println("Witch product do you want to remove? Write name: : ");
			myProducts.deleteProduct(input.next());
			getAdminMenu();
			menuOption();

		case 3:
			myProducts.showAllProducts();
			getAdminMenu();
			menuOption();

		case 4:
			System.out.println("Witch product do you want to update: ");
			String oldName = input.nextLine();

			System.out.println("New name: ");
			String newName = input.nextLine();

			System.out.println("New description: ");
			desc = input.nextLine();

			System.out.println("Price: ");
			price = input.nextInt();
			System.out.println("Count: ");
			count = input.nextInt();
			myProducts.modifyProduct(oldName, newName, desc, price, count);
			getAdminMenu();
			menuOption();

		case 5:
			System.out.println("Product name: ");
			name = input.nextLine();

			myProducts.showDetails(name);
			getAdminMenu();
			menuOption();

		case 6:
			System.out.println("Username: ");
			name = input.nextLine();

			System.out.println("Password: ");
			String password = input.nextLine();
			System.out.println("Privilege: ");
			int privilege = input.nextInt();
			myCustomers.addCustomer(name, password, privilege);
			getAdminMenu();
			menuOption();

		case 7:
			System.out.println("Customer username to delete: ");
			String username = input.nextLine();

			myCustomers.deleteCustomer(username);
			getAdminMenu();
			menuOption();

		case 8:
			System.out.println("Username: ");
			username = input.nextLine();

			myCustomers.searchByName(username);
			getAdminMenu();
			menuOption();

			/*
			 * case 9: myProducts.showAllProducts(); System.out.println(
			 * "Product name: "); String productName = input.nextLine();
			 * 
			 * System.out.println("Count: "); count = input.nextInt();
			 * 
			 * myOrders.addOrder(productName, count); getAdminMenu();
			 * menuOption();
			 */

		default:
			System.out.println("Neplatna volba! Zadajte znova.");
			getAdminMenu();
			menuOption();
		}
	}

}
