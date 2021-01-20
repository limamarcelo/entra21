package model.dao.customerOrder;

import java.util.List;

import model.entity.order.CustomerOrder;

public interface CustomerOrderDAO {
	
	void insertCustomerOrder(CustomerOrder order);

	List<CustomerOrder> listCustomerOrders();

	void removeCustomerOrder(int idCustomerOrder);
	
	void editCustomerOrderName(int idCustomerOrder, String newName);

	void editCustomerOrderSurname(int idCustomerOrder, String newSurname);
	
	void editCustomerOrderPhoneNumber(int idCustomerOrder, String newPhoneNumber);

	void editAllCustomerOrderData(int idCustomerOrder, String newName, String newSurname, String newPhoneNumber);

}