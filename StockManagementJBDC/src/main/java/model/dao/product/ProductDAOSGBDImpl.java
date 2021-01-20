package model.dao.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.product.Product;

public class ProductDAOSGBDImpl implements ProductDAO {

	public void insertProduct(String nameProduct, String codeProduct, String descriptionProduct) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = toConnect();
			pstmt = conn.prepareStatement(
					"INSERT INTO product (name_product, code_product, description_product) VALUES (?,?,?)");

			pstmt.setString(1, nameProduct);
			pstmt.setString(2, codeProduct);
			pstmt.setString(3, descriptionProduct);

			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeProduct(int idProduct) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = toConnect();
			pstmt = conn.prepareStatement("DELETE FROM product WHERE id_product = ?");

			pstmt.setInt(1, idProduct);

			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void editProductName(int idProduct, String newName) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = toConnect();
			pstmt = conn.prepareStatement("UPDATE product set name_product = ? WHERE id_product = ?");

			pstmt.setString(1, newName);
			pstmt.setInt(2, idProduct);

			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void editProductCode(int idProduct, String newCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = toConnect();
			pstmt = conn.prepareStatement("UPDATE product set code_product = ? WHERE id_product = ?");

			pstmt.setString(1, newCode);
			pstmt.setInt(2, idProduct);

			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void editProductDescription(int idProduct, String newDescription) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = toConnect();
			pstmt = conn.prepareStatement("UPDATE product set description_product = ? WHERE id_product = ?");

			pstmt.setString(1, newDescription);
			pstmt.setInt(2, idProduct);

			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void editAllProductData(int idProduct, String newName, String newCode, String newDescription) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = toConnect();
			pstmt = conn.prepareStatement(
					"UPDATE product set name_product=?, code_product=?, description_product = ? WHERE id_product = ?");

			pstmt.setString(1, newName);
			pstmt.setString(2, newCode);
			pstmt.setString(3, newDescription);
			pstmt.setInt(4, idProduct);

			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//este list Products está sendo retirado do banco de dados sem ordenação deixando para o comparador no JAVA fazer a ordenação de acordo com o desejo do usuário.
public List<Product> listProducts() {
		
		ArrayList<Product> products = new ArrayList<Product>();
		Connection conn = null;
		Statement select = null;
		ResultSet rs = null;

		try {
			conn = toConnect();
			select = conn.createStatement();
			rs = select.executeQuery("SELECT id_product, name_product, code_product, description_product FROM product");
			//se tiver necessidade de ordenar direto no banco de dados pode ser feito a pesquisa comentada abaixo, substituindo pela pesquisa acima.
			//ordenação por id_product
			//rs = select.executeQuery("SELECT id_product, name_product, code_product, description_product FROM product ORDER BY id_product ASC");
			//ordenação por name_product
			//rs = select.executeQuery("SELECT id_product, name_product, code_product, description_product FROM product ORDER BY name_product ASC");
			//ordenação por code_product
			//rs = select.executeQuery("SELECT id_product, name_product, code_product, description_product FROM product ORDER BY code_product ASC");

			while (rs.next()) {
			
			int idProduct = rs.getInt("id_product");
			String nameProduct = rs.getString("name_product");
			String codeProduct = rs.getString("code_product");
			String descriptionProduct = rs.getString("description_product");

			Product product = new Product(idProduct, nameProduct, codeProduct, descriptionProduct);
			products.add(product);
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
		return products;
	}

	private Connection toConnect() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_management?useTimezone=true&serverTimezone=UTC&user=root&password=M12345@");
	}
}