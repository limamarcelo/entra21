package model.factory.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConnectionFactory {

	public SessionFactory getConnection() {

		Configuration configuration = new Configuration();

		configuration.addAnnotatedClass(model.entity.customer.Customer.class);
		configuration.addAnnotatedClass(model.entity.customer.address.Address.class);
		configuration.addAnnotatedClass(model.entity.customer.order.CustomerOrder.class);
		configuration.addAnnotatedClass(model.entity.customer.order.item.OrderItem.class);
		configuration.addAnnotatedClass(model.entity.product.Product.class);

		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

		SessionFactory factorySession = configuration.buildSessionFactory(service);

		return factorySession;
	}
}