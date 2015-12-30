package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import data.Order;
import data.Product;
import starter.connect_DB;

public class OrderController extends connect_DB {
	
	Connection conn = getDBConnection();
	Statement stmt = null;
	ResultSet result = null;

	private List<Order> orderList = new ArrayList<>();

	public OrderController(List<Order> orderList) {
		super();
		this.orderList = orderList;
	}

	
	public void selectProducts(String productName, int count) throws SQLException {
		Connection conn = getDBConnection();
		Statement stmt = null;
		ResultSet result = null;
		try {

			stmt = conn.createStatement();
			result = stmt.executeQuery("select user_id from loged_user");
			while (result.next()) {
				
				// tu som skoncil 30.12.2015 o 15.40
				//plan je taky, aby sa objednavky vkladali najprv do kosika a nasledne sa ID kosika vkladalo do tab objednavky
				stmt.executeUpdate("");
			}
			
				stmt.executeUpdate("");
			

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
	 * vymaze objednavku
	 * 
	 * @param order
	 *            objednavka ktoru chceme vymazat
	 */
	public void removeOrder() {

	}

}
