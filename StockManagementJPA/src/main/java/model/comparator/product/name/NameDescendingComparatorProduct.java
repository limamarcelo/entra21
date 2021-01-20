package model.comparator.product.name;

import java.util.Comparator;

import model.entity.product.Product;

public class NameDescendingComparatorProduct implements Comparator<Product> {

	public int compare(Product product1, Product product2) {
		return product1.getName().compareTo(product2.getName()) * -1;
	}
}