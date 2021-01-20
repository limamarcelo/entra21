package model.dao.customer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.customer.Customer;

public class CustomerDAOSGBDImpl implements CustomerDAO {

	public void insertCustomer(Customer customer) {
		Session session = null;

		try {

			session = buildSessionFactory().openSession();
			session.beginTransaction();

			session.save(customer);

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

			sqlException.printStackTrace();

		} finally {

			if (session != null) {
				session.close();
			}
		}

	}

	public void removeCustomer(Customer customer) {
		Session session = null;

		try {

			session = buildSessionFactory().openSession();
			session.beginTransaction();

			session.delete(customer);

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

			sqlException.printStackTrace();

		} finally {

			if (session != null) {
				session.close();
			}
		}

	}

	public void updateCustomer(Customer customer) {
		Session session = null;
		
		try {
			session = buildSessionFactory().openSession();
			session.beginTransaction();

			session.update(customer);

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

			sqlException.printStackTrace();

		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	public List<Customer> listCustomers() {

		Session session = buildSessionFactory().openSession();

		String select = "FROM Customer";
		Query query = session.createQuery(select);

		return query.list();
	}

	public List<Customer> listCustomersOrderByIdAsc() {

		List<Customer> customers = new ArrayList<Customer>();

		
		
		return customers;
	}

	public List<Customer> listCustomersOrderByIdDesc() {

		List<Customer> customers = new ArrayList<Customer>();

		return customers;
	}
	
	public List<Customer> listCustomersOrderByNameAsc() {

		List<Customer> customers = new ArrayList<Customer>();

		return customers;
	}

	public List<Customer> listCustomersOrderByNameDesc() {

		List<Customer> customers = new ArrayList<Customer>();

		return customers;
	}

	public List<Customer> listCustomersOrderByCpfAsc() {

		List<Customer> customers = new ArrayList<Customer>();

		return customers;
	}

	public List<Customer> listCustomersOrderByCpfDesc() {

		List<Customer> customers = new ArrayList<Customer>();

		return customers;
	}

	public List<Customer> listCustomersOrderByAgeAsc() {

		List<Customer> customers = new ArrayList<Customer>();

		return customers;
	}

	public List<Customer> listCustomersOrderByAgeDesc() {

		List<Customer> customers = new ArrayList<Customer>();

		return customers;
	}

	public List<Customer> listCustomersOrderByDebtAsc() {

		List<Customer> customers = new ArrayList<Customer>();

		return customers;
	}

	public List<Customer> listCustomersOrderByDebtDesc() {

		List<Customer> customers = new ArrayList<Customer>();

		return customers;
	}

	private SessionFactory buildSessionFactory() {
		
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(model.customer.Customer.class);
		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		return sessionFactory;
		
	}
}