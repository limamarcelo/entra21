package model.dao.customerOrder;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import model.entity.customer.order.CustomerOrder;

public interface CustomerOrderDAO {
	
	void insertCustomerOrder(CustomerOrder order);

	List<CustomerOrder> listCustomerOrders() throws HibernateException, SQLException;

	void deleteCustomerOrder(CustomerOrder order);
	
	void updateCustomerOrder(CustomerOrder order);
	
}