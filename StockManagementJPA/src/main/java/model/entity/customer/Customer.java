package model.entity.customer;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.entity.customer.address.Address;
import model.entity.customer.order.CustomerOrder;
import model.execptions.CustomerNameException;
import model.execptions.CustomerSurnameException;

@Entity
@Table(name = "customer")
public class Customer implements Comparable<Customer>, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_customer")
	private Long id;

	@Column(name = "name_customer", length = 45, nullable = false, unique = false)
	private String name;

	@Column(name = "surname_customer", length = 45, nullable = false, unique = false)
	private String surname;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CustomerOrder> orders = new ArrayList<CustomerOrder>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "customer_address", joinColumns = @JoinColumn(name = "id_customer"), inverseJoinColumns = @JoinColumn(name = "id_address"))
	private List<Address> addresses = new ArrayList<Address>();

	public Customer() {
	}

	public Customer(String name, String surname)
			throws CustomerNameException, CustomerSurnameException {
		setName(name);
		setSurname(surname);
	}

	public Customer(Long id, String name, String surname)
			throws CustomerNameException, CustomerSurnameException {
		setId(id);
		setName(name);
		setSurname(surname);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws CustomerNameException {
		if (name.isEmpty()) {
			throw new CustomerNameException("Nome do cliente não deve estar em branco");
		}
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) throws CustomerSurnameException {
		if (surname.isEmpty()) {
			throw new CustomerSurnameException("Sobrenome do cliente não deve estar em branco");
		}
		this.surname = surname;
	}

	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void addOrders(CustomerOrder order) {
		this.orders.add(order);
	}

	public void removeOrders(CustomerOrder order) {
		this.orders.remove(order);
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void addAddresses(Address address) {
		this.addresses.add(address);
	}

	public void removeAddresses(Address address) {
		this.addresses.remove(address);
	}
	public int compareTo(Customer customer) {
		if (this == customer)
			return 0;

		if (customer == null)
			return 0;

		// this.getClass() ou getClass tanto faz.
		if (getClass() != customer.getClass())
			return 0;

		// Customer name = customer;

		// comparar id com != por ser tipo primitivo e o restante com o equals por ser
		// utilizando o equals
		if (!(getName().equals(customer.getName())))
			return 0;
		return 1;
	}
}