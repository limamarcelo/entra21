package model.comparator.product.id;

import java.util.Comparator;

import model.entity.product.Product;

public class IdAscendingComparatorProduct implements Comparator<Product> {

	public int compare(Product product1, Product product2) {

		if (product1.getId() > product2.getId())
			return 1;

		if (product1.getId() < product2.getId())
			return -1;

		return 0;
	}
}