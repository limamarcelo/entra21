package model.comparator.customer.surname;

import java.util.Comparator;

import model.entity.customer.Customer;

public class SurnameDescendingComparatorCustomer implements Comparator<Customer> {

	public int compare(Customer customer1, Customer customer2) {
		return customer1.getSurname().compareTo(customer2.getSurname()) * -1;
	}
}