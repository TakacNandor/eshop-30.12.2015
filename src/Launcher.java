import java.util.ArrayList;
import java.util.List;

import eshop.Controllers.ProductController;
import eshop.data.Customer;
import eshop.data.Order;
import eshop.data.Product;

public class Launcher {

	public static void main(String[] args) {

		List<Product> productList = new ArrayList<>();
		List<Customer> customerList = new ArrayList<>();
		List<Order> orderList = new ArrayList<>();

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

	}

}
