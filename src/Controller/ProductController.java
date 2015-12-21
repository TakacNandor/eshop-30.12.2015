package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import data.Product;

public class ProductController {

	private List<Product> productList = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	public ProductController(List<Product> product) {
		this.productList = product;
	}

	/**
	 * prida novy produkt
	 * 
	 * @param name
	 *            je meno produktu
	 * @param description
	 *            je popis produktu
	 */
	public void addProduct(String name, String desc, int price) {

		boolean a = true;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop_db?user=root&password=");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select product_name from product");
			while (result.next()) {

				if (result.getString("product_name").equals(name)) {
					System.out.println("This product already exist.");
					a = false;
					break;
				}
			}
			if (a) {
				statement.executeUpdate(
						"INSERT INTO `product` (`id_product`, `product_name`, `product_desc`, `price`) VALUES (NULL, '"
								+ name + "', '" + desc + "', '" + price + "');");
			}
			connection.close();
		} catch (SQLException sx) {
			System.out.println("SQLException: " + sx.getMessage());
			System.out.println("SQLState: " + sx.getSQLState());
			System.out.println("VendorError: " + sx.getErrorCode());
		}

	}

	/**
	 * vyhlada produkt
	 * 
	 * @param name
	 *            meno produktu
	 * @return vrati produkt ktory hladame
	 */
	public Product searchByName(String name) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop_db?user=root&password=");
			Statement statement = connection.createStatement();
			ResultSet result = statement
					.executeQuery("select product_name from product where product_name like '" + name + "%'");
			while (result.next()) {
				System.out.println("Search resut: ");
				System.out.print(result.getString("product_name"));
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

	/**
	 * zmaze produkt zo zoznamu
	 * 
	 * @param produkt
	 *            ktory chceme zmazat
	 */
	public void deleteProduct(String name) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop_db?user=root&password=");
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM product WHERE product_name='" + name + "';");

			connection.close();
		} catch (SQLException sx) {
			System.out.println("SQLException: " + sx.getMessage());
			System.out.println("SQLState: " + sx.getSQLState());
			System.out.println("VendorError: " + sx.getErrorCode());
		}
	}

	/**
	 * zmeni parametre produktu
	 * 
	 * @param product
	 *            objekt ktory cheme zmenit
	 * @param name
	 *            nove meno
	 * @param description
	 *            novy popis
	 */
	public void modifyProduct(String oldName, String newName, String desc, int cena) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop_db?user=root&password=");
			Statement statement = connection.createStatement();
			
			//toto mi nefunguje a neviem preco
			statement.executeUpdate("UPDATE product SET product_name='"+newName+"', product_desc='"+desc+"', price="+cena+" WHERE product.product_name ='"+oldName+"';");
			
			connection.close();
		} catch (SQLException sx) {
			System.out.println("SQLException: " + sx.getMessage());
			System.out.println("SQLState: " + sx.getSQLState());
			System.out.println("VendorError: " + sx.getErrorCode());
		}
	}

	

	/**
	 * vypise info o produkte
	 * 
	 * @param product
	 *            produkt, ktoreho info chceme vziskat
	 */
	public void showDetails(String name) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop_db?user=root&password=");
			Statement statement = connection.createStatement();
			
			//toto mi nefunguje a neviem preco
			ResultSet result = statement.executeQuery("select * from product where product_name='"+name+"';");
			while(result.next()){
			System.out.println("details: ");
			System.out.print(result.getString("product_name"));
			System.out.print("- ");
			System.out.println(result.getString("product_desc"));
			System.out.println("Price: "+result.getString("price"));
			}
			
			connection.close();
		} catch (SQLException sx) {
			System.out.println("SQLException: " + sx.getMessage());
			System.out.println("SQLState: " + sx.getSQLState());
			System.out.println("VendorError: " + sx.getErrorCode());
		}
	}

}
