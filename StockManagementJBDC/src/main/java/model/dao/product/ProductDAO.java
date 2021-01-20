package model.dao.product;

import java.util.List;

import model.entity.product.Product;

public interface ProductDAO {

	void insertProduct(String name, String code, String description);

	List<Product> listProducts();

	void removeProduct(int idProduct);

	void editProductName(int idProduct, String newName);

	void editProductCode(int idProduct, String newCode);

	void editProductDescription(int idProduct, String newDescription);

	void editAllProductData(int idProduct, String newName, String newCode, String newDescription);
}
