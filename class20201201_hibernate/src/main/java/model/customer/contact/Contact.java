package model.customer.contact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@Column (name = "id_customer")
	private int id;
	@Column (name = "phone_number", length = 20, nullable = false, unique = true)
	private String phoneNumber;
	@Column (name = "email", length = 40, nullable = false, unique = true)
	private String email;
	
	public Contact() {}

	public Contact(int id, String phoneNumber, String email) {
		setId(id);
		setPhoneNumber(phoneNumber);
		setEmail(email);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}