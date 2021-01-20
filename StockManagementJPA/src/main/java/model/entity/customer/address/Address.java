package model.entity.customer.address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import model.entity.customer.Customer;
import model.execptions.CustomerPhoneNumberException;
import model.execptions.CustomerPublicPlaceException;

@Entity
@Table(name = "address", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "public_place_address", "number_address", "phone_number_address" }) })
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_customer_address")
	private Long id;

	@Column(name = "public_place_address", length = 45, nullable = false)
	private String publicPlace;

	@Column(name = "number_address", nullable = false)
	private short placeNumber;

	@Column(name = "phone_number_address", length = 14, nullable = false, unique = false)
	private String phoneNumber;

	@ManyToMany(mappedBy = "addresses")
	private List<Customer> customers = new ArrayList<Customer>();

	public Address() {
	}

	public Address(String publicPlace, short placeNumber, String phoneNumber)
			throws CustomerPhoneNumberException, CustomerPublicPlaceException {
		setPublicPlace(publicPlace);
		setPlaceNumber(placeNumber);
		setPhoneNumber(phoneNumber);
	}

	public Address(Long id, String publicPlace, short placeNumber, String phoneNumber)
			throws CustomerPhoneNumberException, CustomerPublicPlaceException {
		setId(id);
		setPublicPlace(publicPlace);
		setPlaceNumber(placeNumber);
		setPhoneNumber(phoneNumber);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) throws CustomerPublicPlaceException {
		if (publicPlace.isEmpty()) {
			throw new CustomerPublicPlaceException("Endereço do cliente não deve estar em branco");
		}
		this.publicPlace = publicPlace;
	}

	public short getPlaceNumber() {
		return placeNumber;
	}

	public void setPlaceNumber(short placeNumber) {
		this.placeNumber = placeNumber;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void addCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws CustomerPhoneNumberException {
		if (phoneNumber.isEmpty()) {
			throw new CustomerPhoneNumberException("Telefone do cliente não deve estar em branco");
		}
		this.phoneNumber = phoneNumber;
	}
}