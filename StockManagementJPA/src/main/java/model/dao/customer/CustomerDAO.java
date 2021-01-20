package model.dao.customer;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import model.entity.customer.Customer;

public interface CustomerDAO {

	void insertCustomer(Customer customer);

	List<Customer> listCustomers() throws HibernateException, SQLException;

	void updateCustomer(Customer customer);

	void deleteCustomer(Customer customer);
}