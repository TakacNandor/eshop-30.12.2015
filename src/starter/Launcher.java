package starter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.ProductController;
import account.Account;
import account.Login;
import data.Customer;
import data.Order;
import data.Product;

public class Launcher {

	public static void main(String[] args) throws Exception{

		List<Product> productList = new ArrayList<>();
		List<Customer> customerList = new ArrayList<>();
		List<Order> orderList = new ArrayList<>();

		
		Menu menu = new Menu(productList, customerList, orderList);
		Login login = new Login();
		
		
		login.userLogin();
		menu.getMenu();
		//login.userLogout();
		
		
				
		
		
	}

}
