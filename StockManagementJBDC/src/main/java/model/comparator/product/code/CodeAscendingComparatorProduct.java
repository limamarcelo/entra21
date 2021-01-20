package model.comparator.product.code;

import java.util.Comparator;

import model.entity.product.Product;

public class CodeAscendingComparatorProduct implements Comparator<Product> {

	public int compare(Product product1, Product product2) {
		return product1.getCode().compareTo(product2.getCode());
	}
}