package comparator.customer.name;

import java.util.Comparator;

import model.customer.Customer;

public class NameDescendingComparatorCustomer implements Comparator<Customer> {

	public int compare(Customer customer1, Customer customer2) {
		return customer1.getName().compareTo(customer2.getName()) * -1;
	}
}