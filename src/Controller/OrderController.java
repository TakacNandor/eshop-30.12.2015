package Controller;

import java.util.*;

import data.Order;
import data.Product;

public class OrderController {

	private List<Order> orderList = new ArrayList<>();

	public OrderController(List<Order> orderList) {
		super();
		this.orderList = orderList;
	}
/**
 * prida objednavku
 * @param order objednavka ktoru chceme pridat
 */
	public void addOrder(Order order) {
		orderList.add(order);
	}
	/**
	 * vymaze objednavku
	 * @param order objednavka ktoru chceme vymazat
	 */
	public void removeOrder(Order order){
		for (Order order1 : orderList) {
			if (order1.equals(order)) {
				orderList.remove(order1);
			}
		}
	}
	
	

}
