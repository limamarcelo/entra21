package model.dao.customer;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import model.entity.customer.Customer;
import model.factory.connection.ConnectionFactory;

public class CustomerDAOSGBDImpl implements CustomerDAO {

	private ConnectionFactory factory;

	public CustomerDAOSGBDImpl() {
		factory = new ConnectionFactory();
	}

	public void insertCustomer(Customer customer) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.save(customer);

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

	public List<Customer> listCustomers() throws HibernateException, SQLException {

		Session session = factory.getConnection().openSession();
		CriteriaBuilder constructor = session.getCriteriaBuilder();

		// criteria poderia ser consulta ou query
		CriteriaQuery<Customer> criteria = constructor.createQuery(Customer.class);
		Root<Customer> rootCustomer = criteria.from(Customer.class);

		criteria.select(rootCustomer).getOrderList().sort(null);

		return session.createQuery(criteria).getResultList();
	}

	public void updateCustomer(Customer customer) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.merge(customer);

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

	public void deleteCustomer(Customer customer) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.remove(customer);

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