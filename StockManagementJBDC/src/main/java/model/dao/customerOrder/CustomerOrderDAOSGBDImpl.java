package model.dao.customerOrder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entity.order.CustomerOrder;
import model.entity.order.item.OrderItem;
import model.entity.product.Product;

public class CustomerOrderDAOSGBDImpl implements CustomerOrderDAO {

	public void insertCustomerOrder(CustomerOrder order) {
		Connection conn = null;
		PreparedStatement insert = null;
		ResultSet rs = null;
		int idOrder = 0;
		try {
			// cadastrar pedido
			conn = toConnect();
			insert = conn.prepareStatement(
					"INSERT INTO customer_order (id_customer, date_order, total_order) VALUES (?,?,?) and INSETR INTO order_item (id_order, id_customer, id_product, quantity_product, price_product) VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			insert.setInt(1, order.getCustomerId());
			insert.setDate(2, (java.sql.Date) order.getDate());
			insert.execute();

			// retornar id gerado durante o cadasto do pedido
			rs = insert.getGeneratedKeys();

			if (rs.next()) {
				idOrder = rs.getInt(1);
			}

			for (int i = 0; i < order.getItems().size(); i++) {
				insert = conn.prepareStatement(
						"INSERT INTO orderItem (id_order, id_customer, id_product, quantity_product, price_product) VALUES (?,?,?,?)");
				insert.setInt(1, idOrder);
				insert.setInt(2, order.getCustomerId());
				insert.setInt(3, order.getItems().get(i).getProduct().getId());
				insert.setFloat(4, order.getItems().get(i).getQuantity());
				insert.setFloat(5, order.getItems().get(i).getPrice());
				insert.execute();
			}

			insert.setFloat(3, order.getTotal());
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

	public void removeCustomerOrder(int idCustomerOrder) {
		Connection conn = null;
		PreparedStatement delete = null;

		try {
			conn = toConnect();
			delete = conn.prepareStatement("DELETE FROM customer WHERE id_customer = ?");
			delete.setInt(1, idCustomerOrder);
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

	public void editCustomerOrderName(int idCustomerOrder, String newName) {
		Connection conn = null;
		PreparedStatement update = null;

		try {
			conn = toConnect();
			update = conn.prepareStatement("UPDATE customer set name_customer = ? WHERE id_customer = ?");
			update.setString(1, newName);
			update.setInt(2, idCustomerOrder);
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

	public void editCustomerOrderSurname(int idCustomerOrder, String newSurname) {
		Connection conn = null;
		PreparedStatement update = null;

		try {
			conn = toConnect();
			update = conn.prepareStatement("UPDATE customer set surname_customer = ? WHERE id_customer = ?");
			update.setString(1, newSurname);
			update.setInt(2, idCustomerOrder);

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

	public void editCustomerOrderPhoneNumber(int idCustomerOrder, String newPhoneNumber) {
		Connection conn = null;
		PreparedStatement update = null;

		try {
			conn = toConnect();
			update = conn.prepareStatement("UPDATE customer set phonenumber_customer = ? WHERE id_customer = ?");
			update.setString(1, newPhoneNumber);
			update.setInt(2, idCustomerOrder);
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

	public void editAllCustomerOrderData(int idCustomerOrder, String newName, String newSurname,
			String newPhoneNumber) {
		Connection conn = null;
		PreparedStatement update = null;

		try {
			conn = toConnect();
			update = conn.prepareStatement(
					"UPDATE customer set name_customer = ?, surname_customer = ?, phonenumber_customer = ? WHERE id_customer = ?");

			update.setString(1, newName);
			update.setString(2, newSurname);
			update.setString(3, newPhoneNumber);
			update.setInt(4, idCustomerOrder);
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

	public List<CustomerOrder> listCustomerOrders() {
		//falta ajustar select para listar pedido com produtos.
		ArrayList<Product> product = new ArrayList<Product>();
		ArrayList<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
		Connection conn = null;
		Statement select = null;
		ResultSet rs = null;

		try {
			conn = toConnect();
			select = conn.createStatement();
			rs = select.executeQuery(
					"SELECT id_order, id_customer, date_order, id_product, quantity_product, price_product, total_order FROM customer_order ORDER BY id_order ASC");
			while (rs.next()) {

				for (int i = 0; i < customerOrders.get(i).getItems().size(); i++) {
					
					int orderId = rs.getInt("id_order");
					int customerId = rs.getInt("id_customer");
					Date date = rs.getDate("date_order");
					int productId = rs.getInt("id_product");
					float quantity = rs.getFloat("quantity_product");
					float price = rs.getFloat("price_product");
					//buscando pelo objeto, para teste.
					//int productId = rs.getInt(customerOrders.get(idOrder).getItems().get(i).getProduct().getId());
					//float quantity = rs.getFloat(customerOrders.get(idOrder).getItems().get(i).getQuantity());
					//float price = rs.getFloat(customerOrders.get(idOrder).getItems().get(i).getPrice());
					//float totalOrderItem = rs.getFloat(customerOrders.get(idOrder).getItems().get(i).getTotalOrderItem());
					//float totalOrder = rs.getFloat(customerOrders.get(idOrder).getTotalOrder());
					OrderItem items = new OrderItem(productId, quantity, price);
					float total = customerOrders.get(orderId).getTotal();
					CustomerOrder customerOrder = new CustomerOrder(orderId, customerId, date, items, total);
					customerOrders.add(customerOrder);

				}
				
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
		return customerOrders;
	}

	private Connection toConnect() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/stock_management?useTimezone=true&serverTimezone=UTC&user=root&password=M12345@");
	}
}