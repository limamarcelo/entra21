package model.dao.customer.address;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import model.entity.customer.address.Address;

public interface AddressDAO {

	void insertAddress(Address address);

	List<Address> listAddresses() throws HibernateException, SQLException;

	void updateAddress(Address address);

	void deleteAddress(Address address);

}