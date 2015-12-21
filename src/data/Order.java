package data;

public class Order {

	private Product product;
	private Customer customer;
	private int numberOfProducts;

	public Order(Product product, Customer customer, int numberOfProducts) {
		super();
		this.product = product;
		this.customer = customer;
		this.numberOfProducts = numberOfProducts;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(int numberOfProducts) {
		if (numberOfProducts <= 0) {
			System.out.println("Invalid number of products");
		}
		this.numberOfProducts = numberOfProducts;
	}

}
