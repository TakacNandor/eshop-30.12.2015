package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import data.Product;
import starter.connect_DB;

public class ProductController extends connect_DB {

	// private List<Product> productList = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	public ProductController(List<Product> product) {
		// this.productList = product;
	}

	/**
	 * prida novy produkt
	 * 
	 * @param name
	 *            je meno produktu
	 * @param description
	 *            je popis produktu
	 * @throws SQLException
	 */
	public void addProduct(String name, String desc, int price, int count) throws SQLException {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet result = null;
		boolean a = true;
		try {

			stmt = conn.createStatement();
			result = stmt.executeQuery("select product_name from product");
			while (result.next()) {

				if (result.getString("product_name").equals(name)) {
					System.out.println("This product already exist.");
					a = false;
					break;
				}
			}
			if (a) {
				stmt.executeUpdate(
						"INSERT INTO `product` (`id_product`, `product_name`, `product_desc`, `price`, `count`) VALUES (NULL, '"
								+ name + "', '" + desc + "', '" + price + "', '" + count + "');");
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

	/**
	 * vyhlada produkt
	 * 
	 * @param name
	 *            meno produktu
	 * @return vrati produkt ktory hladame
	 * @throws SQLException
	 */
	public void searchByName(String name) throws SQLException {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet result = null;
		try {
			stmt = conn.createStatement();
			result = stmt.executeQuery("select product_name from product where product_name like '" + name + "%'");
			while (result.next()) {
				System.out.println("Search resut: ");
				System.out.print(result.getString("product_name"));
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

	/**
	 * zmaze produkt zo zoznamu
	 * 
	 * @param produkt
	 *            ktory chceme zmazat
	 * @throws SQLException
	 */
	public void deleteProduct(String name) throws SQLException {
		Connection conn = getDBConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM product WHERE product_name='" + name + "';");

		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
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
	 * @throws SQLException
	 */
	public void modifyProduct(String oldName, String newName, String desc, int cena, int count) throws SQLException {
		Connection conn = getDBConnection();
		Statement stmt = null;
		try {

			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE product SET product_name='" + newName + "', product_desc='" + desc + "', price="
					+ cena + ", price=" + count + " WHERE product.product_name ='" + oldName + "';");

		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void showAllProducts() throws SQLException {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet result = null;
		try {
			stmt = conn.createStatement();

			result = stmt.executeQuery("select product_name from product;");
			System.out.print("List of products: ");
			while (result.next()) {
				System.out.print(result.getString("product_name"));
				System.out.print(", ");
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

	/**
	 * vypise info o produkte
	 * 
	 * @param product
	 *            produkt, ktoreho info chceme vziskat
	 * @throws SQLException
	 */
	public void showDetails(String name) throws SQLException {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet result = null;
		try {
			stmt = conn.createStatement();
			result = stmt.executeQuery("select * from product where product_name='" + name + "';");
			while (result.next()) {
				System.out.println("details: ");
				System.out.print(result.getString("product_name"));
				System.out.print("- ");
				System.out.println(result.getString("product_desc"));
				System.out.println("Price: " + result.getInt("price"));
				System.out.println("Available: " + result.getInt("count"));
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

}
