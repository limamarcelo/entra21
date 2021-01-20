package model.entity.order;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import model.entity.order.item.OrderItem;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private int id;
	@Column(name = "id_customer")
	private int customerId;
	@Column(name = "date_order")
	private Date date;

	private List<OrderItem> items;
	@Column(name = "total_order")
	private float total;

	public CustomerOrder(int customerId, Date date, List<OrderItem> items, List<OrderItem> total) {
		setCustomerId(customerId);
		setDate(date);
		setItems(items);
		setTotal(total);
	}

	public CustomerOrder(int id, int customerId, Date date, List<OrderItem> items, List<OrderItem> total) {
		setId(id);
		setCustomerId(customerId);
		setDate(date);
		setItems(items);
		setTotal(total);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public float getTotal() {
		float sum = 0;
		for (int i = 0; i < items.size(); i++) {
			total += items.get(id).getQuantity() * items.get(id).getPrice();
		}
		total = sum;
		return total;
	}

	public void setTotal(List<OrderItem> items) {
		float sum = 0;
		for (int i = 0; i < items.size(); i++) {
			sum = items.get(id).getQuantity() * items.get(id).getPrice();
		}
		this.total = sum;
	}
}