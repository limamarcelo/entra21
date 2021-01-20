package model.dao.customer.address;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import model.entity.customer.address.Address;
import model.factory.connection.ConnectionFactory;

public class AddressDAOSGBDImpl implements AddressDAO {

	private ConnectionFactory factory;

	public AddressDAOSGBDImpl() {
		factory = new ConnectionFactory();
	}

	public void insertAddress(Address address) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.save(address);

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

	public List<Address> listAddresses() throws HibernateException, SQLException {

		Session session = factory.getConnection().openSession();
		CriteriaBuilder constructor = session.getCriteriaBuilder();

		// criteria poderia ser consulta ou query
		CriteriaQuery<Address> criteria = constructor.createQuery(Address.class);
		Root<Address> rootAddress = criteria.from(Address.class);

		criteria.select(rootAddress);

		return session.createQuery(criteria).getResultList();
	}

	public void updateAddress(Address address) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.merge(address);

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

	public void deleteAddress(Address address) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.remove(address);

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