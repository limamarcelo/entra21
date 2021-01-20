package model.dao.customer;

import java.util.List;

import model.entity.customer.Customer;

public interface CustomerDAO {
	
	void insertCustomer(String name, String surname, String phoneNumber);

	List<Customer> listCustomers();

	void removeCustomer(int id);
	
	void editCustomerName(int id, String newName);

	void editCustomerSurname(int id, String newSurname);
	
	void editCustomerPhoneNumber(int id, String newPhoneNumber);

	void editAllCustomerData(int id, String newName, String newSurname, String newPhoneNumber);

}