package model.dao.customerOrder;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import model.entity.customer.order.CustomerOrder;
import model.factory.connection.ConnectionFactory;

public class CustomerOrderDAOSGBDImpl implements CustomerOrderDAO {

	private ConnectionFactory factory;

	public CustomerOrderDAOSGBDImpl() {
		factory = new ConnectionFactory();
	}

	public void insertCustomerOrder(CustomerOrder order) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.save(order);

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

	public List<CustomerOrder> listCustomerOrders() throws HibernateException, SQLException {

		Session session = factory.getConnection().openSession();
		CriteriaBuilder constructor = session.getCriteriaBuilder();

		CriteriaQuery<CustomerOrder> criteria = constructor.createQuery(CustomerOrder.class);
		Root<CustomerOrder> rootCustomerOrder = criteria.from(CustomerOrder.class);

		criteria.select(rootCustomerOrder);

		return session.createQuery(criteria).getResultList();
	}

	public void updateCustomerOrder(CustomerOrder order) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.merge(order);

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

	public void deleteCustomerOrder(CustomerOrder order) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.remove(order);

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