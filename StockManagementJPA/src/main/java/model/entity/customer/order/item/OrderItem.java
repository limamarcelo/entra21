package model.entity.customer.order.item;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.entity.customer.order.CustomerOrder;
import model.entity.product.Product;

@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order_item")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order", nullable = false)
	private CustomerOrder order;

	@ManyToOne(fetch = FetchType.LAZY) // , cascade = {CascadeType.PERSIST, CascadeType.MERGE}
	@JoinColumn(name = "id_product", nullable = false)
	private Product product;

	@Column(name = "quantity_product", nullable = false, unique = false)
	private float quantity;

	@Column(name = "price_product", nullable = false, unique = false)
	private float price;

	public OrderItem() {
	}

	public OrderItem(CustomerOrder order, Product product, float quantity, float price) {
		setOrder(order);
		setProduct(product);
		setQuantity(quantity);
		setPrice(price);
	}

	public CustomerOrder getOrder() {
		return order;
	}

	public void setOrder(CustomerOrder order) {
		this.order = order;
	}

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