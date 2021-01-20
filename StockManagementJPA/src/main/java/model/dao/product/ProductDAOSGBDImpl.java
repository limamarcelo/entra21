package model.dao.product;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import model.entity.product.Product;
import model.factory.connection.ConnectionFactory;

public class ProductDAOSGBDImpl implements ProductDAO {

	private ConnectionFactory factory;
	
	public ProductDAOSGBDImpl() {
		factory = new ConnectionFactory();
	}
	
	public void insertProduct(Product product) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.save(product);

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	public List<Product> listProducts() throws HibernateException, SQLException {

		Session session = factory.getConnection().openSession();
		CriteriaBuilder constructor = session.getCriteriaBuilder();

		// criteria poderia ser consulta ou query
		CriteriaQuery<Product> criteria = constructor.createQuery(Product.class);
		Root<Product> rootProduct = criteria.from(Product.class);

		criteria.select(rootProduct).getOrderList().sort(null);

		return session.createQuery(criteria).getResultList();
	}
	
	public void updateProduct(Product product) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.merge(product);

			session.getTransaction().commit();

		} catch (Exception sqlException) {
			sqlException.printStackTrace();

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteProduct(Product product) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.remove(product);

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}
		}
	}
}