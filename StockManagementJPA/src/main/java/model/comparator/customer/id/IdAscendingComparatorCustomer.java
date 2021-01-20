package model.comparator.customer.id;

import java.util.Comparator;

import model.entity.customer.Customer;

public class IdAscendingComparatorCustomer implements Comparator<Customer> {

	public int compare(Customer customer1, Customer customer2) {

		if (customer1.getId() > customer2.getId())
			return 1;

		if (customer1.getId() < customer2.getId())
			return -1;

		return 0;
	}
}