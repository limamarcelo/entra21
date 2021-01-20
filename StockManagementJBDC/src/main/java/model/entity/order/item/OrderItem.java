package model.entity.order.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import model.entity.product.Product;
@Entity
@Table(name="order_item")
public class OrderItem {

	private Product product;
	@Column(name="quantity_product")
	private float quantity;
	@Column(name="price_product")
	private float price;

	public OrderItem() {
	}

	public OrderItem(Product product, float quantity, float price) {
		setProduct(product);
		setQuantity(quantity);
		setPrice(price);
	}

	/*
	 * public OrderItem(CustomerOrder order, Customer customer, Product product,
	 * float quantity, float price) { setOrder(order); setCustomer(customer);
	 * setProduct(product); setQuantity(quantity); setPrice(price); }
	 * 
	 * public OrderItem(CustomerOrder order, Customer customer, Product product,
	 * float quantity, float price, float totalOrderItem) { setOrder(order);
	 * setCustomer(customer); setProduct(product); setQuantity(quantity);
	 * setPrice(price); setTotalOrderItem(totalOrderItem); }
	 * 
	 * 
	 * public CustomerOrder getOrder() { return order; }
	 * 
	 * public void setOrder(CustomerOrder order) { this.order = order; }
	 * 
	 * public Customer getCustomer() { return customer; }
	 * 
	 * public void setCustomer(Customer customer) { this.customer = customer; }
	 */

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}