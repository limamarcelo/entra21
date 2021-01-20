package model.comparator.address.publicplace;

import java.util.Comparator;

import model.entity.customer.address.Address;

public class NameDescendingComparatorAddress implements Comparator<Address> {

	public int compare(Address address1, Address address2) {
		return address1.getPublicPlace().compareTo(address2.getPublicPlace()) * -1;
	}
}