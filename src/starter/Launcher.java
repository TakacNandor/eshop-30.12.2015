package starter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.ProductController;
import account.Account;
import data.Customer;
import data.Order;
import data.Product;

public class Launcher {

	public static void main(String[] args) throws IOException {

		List<Product> productList = new ArrayList<>();
		List<Customer> customerList = new ArrayList<>();
		List<Order> orderList = new ArrayList<>();

		
		///PrintWriter writer =  new PrintWriter("src\\accounts.txt");
		Menu menu = new Menu(productList, customerList, orderList);
		/*Product pro1 = new Product("meno", "popis");
		Product pro2 = new Product("asdasd", "pohdfhgdfghddfgpis");
		Product pro3 = new Product("menfsdfso", "pophdfghfghdgfghdfgis");
		Product pro4 = new Product("mengdfgdfgo", "popfdhdfhdfghdfghdfghfdghdfghis");
		
		List<Product> l = new ArrayList<>();
		l.add(pro1);
		l.add(pro2);
		l.add(pro3);
		l.add(pro4);
		
		ProductController p = new ProductController(l);
		System.out.println(p.toString());*/
		menu.getMenu();

		menu.menuOption();
		
		//Account acc = new Account();
		
		//writer.println("trololo");
		//acc.createAcc();
		
	}

}
