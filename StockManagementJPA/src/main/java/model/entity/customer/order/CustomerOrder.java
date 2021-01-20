package model.entity.customer.order;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.entity.customer.Customer;
import model.entity.customer.order.item.OrderItem;

@Entity
@Table(name = "customer_order")
public class CustomerOrder implements Serializable {	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY) //, cascade = {CascadeType.PERSIST, CascadeType.MERGE}
	@JoinColumn(name = "id_customer", nullable=false)
	private Customer customer;
	
	@Column(name = "date_order")
	private Date date;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "customer_order", joinColumns = @JoinColumn(name = "id_order"), inverseJoinColumns = @JoinColumn(name = "id_customer")) // chave composta no banco do order_item por id_order + id_customer + id_product 
	private List<OrderItem> items;

	//precision tamanho do número, e scale casas após a vírgula
	@Column(name = "total_order", precision = 11, scale = 2, nullable = false, unique = false)
	private float total;

	public CustomerOrder(Customer customer, Date date, List<OrderItem> items, List<OrderItem> total) {
		setCustomer(customer);
		setDate(date);
		setTotal(total);
	}

	public CustomerOrder(Long id, Customer customer, Date date, List<OrderItem> items, List<OrderItem> total) {
		setId(id);
		setCustomer(customer);
		setDate(date);
		setTotal(total);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public void addItems(OrderItem item) {
		this.items.add(item);
	}

	public void removeItems(OrderItem item) {
		this.items.remove(item);
	}
	
	public float getTotal() {
		float sum = 0;
		for (int i = 0; i < items.size(); i++) {
			sum += items.get(i).getQuantity() * items.get(i).getPrice();
		}
		return sum;
	}

	public void setTotal(List<OrderItem> items) {
		float sum = 0;
		for (int i = 0; i < items.size(); i++) {
			sum = items.get(i).getQuantity() * items.get(i).getPrice();
		}
		this.total = sum;
	}
}