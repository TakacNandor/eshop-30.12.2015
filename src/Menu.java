import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import eshop.Controllers.CustomerController;
import eshop.Controllers.OrderController;
import eshop.Controllers.ProductController;
import eshop.data.Customer;
import eshop.data.Order;
import eshop.data.Product;

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
		System.out.println("2. Add customer.");
		System.out.println("3. Order a product.");
		System.out.println("4. Remove product.");
		System.out.println("5. Remove Customer.");
		System.out.println("6. Show all products.");
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
			String name = input.nextLine();

			System.out.println("Write description: ");
			String desc = input.nextLine();
			myProducts.addProduct(new Product(name, desc));
			getMenu();
			menuOption();
			

		case 2:
			System.out.println("Firstname: ");
			String firstName = input.nextLine();

			System.out.println("Lastname: ");
			String lastName = input.next();

			System.out.println("Address: ");
			String address = input.nextLine();

			System.out.println("Phone number: ");
			int num = input.nextInt();
			myCustomers.addCustomer(firstName, lastName, address, num);
			getMenu();
			menuOption();
			

		case 3:
			System.out.println("Firstname: ");
			String first = input.nextLine();

			System.out.println("Lastname: ");
			String last = input.nextLine();

			System.out.println("Select product name: ");
			myProducts.toString();

			String meno = input.nextLine();
			System.out.println("Number of products: ");
			int number = input.nextInt();
			myOrders.addOrder(new Order(myProducts.searchByName(meno), myCustomers.searchByName(first, last), number));
			getMenu();
			menuOption();
			

		case 4:
			myProducts.toString();
			System.out.println("Witch product do zou want to remove? Write name: : ");
			myProducts.deleteProduct(myProducts.searchByName(input.nextLine()));
			getMenu();
			menuOption();
			

		case 5:
			System.out.println("Customer firstname to delete: ");
			first = input.nextLine();
			System.out.println("Customer lasttname to delete: ");
			last = input.nextLine();
			myCustomers.searchByName(first, last);
			getMenu();
			menuOption();
			

		case 6:
			System.out.println(myProducts.toString());
			getMenu();
			menuOption();
			

		default:
			System.out.println("Neplatna volba! Zadajte znova.");
			getMenu();
			menuOption();
		}
	}

}
