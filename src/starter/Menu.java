package starter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.CustomerController;
import Controller.OrderController;
import Controller.ProductController;
import data.Customer;
import data.Order;
import data.Product;

public class Menu {

	private List<Product> productList = new ArrayList<>();
	private List<Customer> customerList = new ArrayList<>();
	private List<Order> orderList = new ArrayList<>();

	ProductController myProducts = new ProductController(productList);
	CustomerController myCustomers = new CustomerController(customerList);
	OrderController myOrders = new OrderController(orderList);

	public Menu(List<Product> productList, List<Customer> customerList, List<Order> orderList) {
		this.productList = productList;
		this.orderList = orderList;
		this.customerList = customerList;
	}

	public void getMenu() {

		System.out.println("Menu: ");
		System.out.println("1. Add product.");
		System.out.println("2. Search byname.");
		System.out.println("3. Order a product.");
		System.out.println("4. Remove product.");
		System.out.println("5. Remove Customer.");
		System.out.println("6. Show all products.");
		System.out.println("7. Add user.");
		System.out.println("8. Update product.");
		System.out.println("9. Show product details.");
		System.out.println("0. Finish shopping.");
		System.out.println("Select your option.");

	}

	public void menuOption() {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		int tmp = Integer.parseInt(input.nextLine());
		switch (tmp) {
		case 0:
			System.out.println("End.");
			break;
						
		case 1:
			System.out.println("Product name: ");
			String  name = input.nextLine();

			System.out.println("Description: ");
			String desc = input.nextLine();
			
			System.out.println("Price: ");
			int price = input.nextInt();
			myProducts.addProduct(name, desc, price);
			getMenu();
			menuOption();
			

		case 2:
			System.out.println("Username: ");
			String username = input.nextLine();

			
			myCustomers.searchByName(username);
			getMenu();
			menuOption();
			

		case 3:
			System.out.println("Username: ");
			 username = input.nextLine();

			System.out.println("Select product name: ");
			myProducts.toString();

			String meno = input.nextLine();
			System.out.println("Number of products: ");
			int number = input.nextInt();
			myOrders.addOrder(new Order(myProducts.searchByName(meno), myCustomers.searchByName(username), number));
			getMenu();
			menuOption();
			

		case 4:
			myProducts.toString();
			System.out.println("Witch product do you want to remove? Write name: : ");
			myProducts.deleteProduct(input.next());
			getMenu();
			menuOption();
			

		case 5:
			System.out.println("Customer username to delete: ");
			username = input.nextLine();
			
			myCustomers.deleteCustomer(username);
			getMenu();
			menuOption();
			

		case 6:
			System.out.println(myProducts.toString());
			getMenu();
			menuOption();
			
		case 7:
			System.out.println("Username: ");
			name = input.nextLine();

			System.out.println("Password: ");
			String password = input.nextLine();
			myCustomers.addCustomer(name, password);
			getMenu();
			menuOption();
			
		case 8:
			System.out.println("Witch product do zou want to update: ");
			String oldName = input.nextLine();

			System.out.println("New name: ");
			String newName = input.nextLine();
			
			System.out.println("New description: ");
			desc = input.nextLine();
			
			System.out.println("Price: ");
			price = input.nextInt();
			myProducts.modifyProduct(oldName, newName, desc, price);
			getMenu();
			menuOption();
			
		case 9:
			System.out.println("Product name: ");
			name = input.nextLine();

			
			myProducts.showDetails(name);
			getMenu();
			menuOption();

		default:
			System.out.println("Neplatna volba! Zadajte znova.");
			getMenu();
			menuOption();
		}
	}

}
