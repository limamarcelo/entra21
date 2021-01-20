package model.dao.product;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import model.entity.product.Product;

public interface ProductDAO {

	void insertProduct(Product product);

	List<Product> listProducts() throws HibernateException, SQLException;

	void updateProduct(Product product);

	void deleteProduct(Product product);
}