package model.dao.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.customer.Customer;

public class CustomerDAOSGBDImpl implements CustomerDAO {

	public void insertCustomer(String name, String surname, String phoneNumber) {
		Connection conn = null;
		PreparedStatement insert = null;

		try {
			conn = toConnect();
			insert = conn.prepareStatement(
					"INSERT INTO customer (name_customer, surname_customer, phoneNumber_customer) VALUES (?,?,?)");
			insert.setString(1, name);
			insert.setString(2, surname);
			insert.setString(3, phoneNumber);
			insert.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (insert != null)
					insert.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeCustomer(int id) {
		Connection conn = null;
		PreparedStatement delete = null;

		try {
			conn = toConnect();
			delete = conn.prepareStatement("DELETE FROM customer WHERE id_customer = ?");
			delete.setInt(1, id);
			delete.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (delete != null)
					delete.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void editCustomerName(int id, String newName) {
		Connection conn = null;
		PreparedStatement update = null;

		try {
			conn = toConnect();
			update = conn.prepareStatement("UPDATE customer set name_customer = ? WHERE id_customer = ?");
			update.setString(1, newName);
			update.setInt(2, id);
			update.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (update != null)
					update.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void editCustomerSurname(int id, String newSurname) {
		Connection conn = null;
		PreparedStatement update = null;

		try {
			conn = toConnect();
			update = conn.prepareStatement("UPDATE customer set surname_customer = ? WHERE id_customer = ?");
			update.setString(1, newSurname);
			update.setInt(2, id);

			update.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (update != null)
					update.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void editCustomerPhoneNumber(int id, String newPhoneNumber) {
		Connection conn = null;
		PreparedStatement update = null;

		try {
			conn = toConnect();
			update = conn.prepareStatement("UPDATE customer set phonenumber_customer = ? WHERE id_customer = ?");
			update.setString(1, newPhoneNumber);
			update.setInt(2, id);
			update.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (update != null)
					update.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void editAllCustomerData(int id, String newName, String newSurname, String newPhoneNumber) {
		Connection conn = null;
		PreparedStatement update = null;

		try {
			conn = toConnect();
			update = conn.prepareStatement(
					"UPDATE customer set name_customer = ?, surname_customer = ?, phonenumber_customer = ? WHERE id_customer = ?");

			update.setString(1, newName);
			update.setString(2, newSurname);
			update.setString(3, newPhoneNumber);
			update.setInt(4, id);
			update.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (update != null)
					update.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//este list Customers está sendo retirado do banco de dados sem ordenação deixando para o comparador no JAVA fazer a ordenação de acordo com o desejo do usuário.
	public List<Customer> listCustomers() {	
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Connection conn = null;
		Statement select = null;
		ResultSet rs = null;

		try {
			conn = toConnect();
			select = conn.createStatement();
			rs = select.executeQuery(
					"SELECT id_customer, name_customer, surname_customer, phoneNumber_customer FROM customer");
			//se tiver necessidade de ordenar direto no banco de dados pode ser feito a pesquisa comentada abaixo, substituindo pela pesquisa acima.
			//ordenação por id_customer
			//rs = select.executeQuery("SELECT id_customer, name_customer, surname_customer, phoneNumber_customer FROM customer ORDER BY id_customer ASC");
			//ordenação por name_customer
			//rs = select.executeQuery("SELECT id_customer, name_customer, surname_customer, phoneNumber_customer FROM customer ORDER BY name_customer ASC");
			//ordenação por surname_customer
			//rs = select.executeQuery("SELECT id_customer, name_customer, surname_customer, phoneNumber_customer FROM customer ORDER BY surname_customer ASC");

		while (rs.next()) {
			
			int id = rs.getInt("id_customer");
			String name = rs.getString("name_customer");
			String surname = rs.getString("surname_customer");
			String phoneNumber = rs.getString("phoneNumber_customer");

			Customer customer = new Customer(id, name, surname, phoneNumber);
			customers.add(customer);
		}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (rs != null)
					rs.close();

				if (select != null)
					select.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customers;
	}

	private Connection toConnect() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_management?useTimezone=true&serverTimezone=UTC&user=root&password=M12345@");
	}
}