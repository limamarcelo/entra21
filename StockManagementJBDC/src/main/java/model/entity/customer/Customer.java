package model.entity.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import model.execptions.CustomerNameException;
import model.execptions.CustomerSurnameException;

@Entity
@Table(name = "customer")
public class Customer implements Comparable<Customer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_customer")
	private int id;
	@Column (name="name_customer")
	private String name;
	@Column (name = "surname_customer")
	private String surname;
	@Column (name="phoneNumber_customer")
	private String phoneNumber;

	public Customer() {
	}

	public Customer(String name, String surname, String phoneNumber)
			throws CustomerNameException, CustomerSurnameException {
		setName(name);
		setSurname(surname);
		setPhoneNumber(phoneNumber);
	}

	public Customer(int id)
			throws CustomerNameException, CustomerSurnameException {
		setId(id);
		}

	public Customer(int id, String name, String surname, String phoneNumber)
			throws CustomerNameException, CustomerSurnameException {
		setId(id);
		setName(name);
		setSurname(surname);
		setPhoneNumber(phoneNumber);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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