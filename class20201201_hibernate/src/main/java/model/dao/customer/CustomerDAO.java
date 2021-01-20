package model.dao.customer;

import java.util.List;

import model.customer.Customer;

public interface CustomerDAO {

	void insertCustomer(Customer customer);

	void removeCustomer(Customer customer);
	
	void updateCustomer(Customer customer);

	List<Customer> listCustomers();

	List<Customer> listCustomersOrderByIdAsc();

	List<Customer> listCustomersOrderByIdDesc();
	
	List<Customer> listCustomersOrderByNameAsc();

	List<Customer> listCustomersOrderByNameDesc();

	List<Customer> listCustomersOrderByCpfAsc();

	List<Customer> listCustomersOrderByCpfDesc();
	
	List<Customer> listCustomersOrderByAgeAsc();

	List<Customer> listCustomersOrderByAgeDesc();
	
	List<Customer> listCustomersOrderByDebtAsc();

	List<Customer> listCustomersOrderByDebtDesc();
}