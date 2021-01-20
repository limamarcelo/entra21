package model.comparator.address.id;

import java.util.Comparator;

import model.entity.customer.address.Address;

public class IdDescendingComparatorAddress implements Comparator<Address> {

	public int compare(Address address1, Address address2) {

		if (address1.getId() > address2.getId())
			return -1;

		if (address1.getId() < address2.getId())
			return 1;

		return 0;
	}
}