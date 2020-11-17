package class_20201112;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?useTimezone=true&serverTimezone=UTC&user=root&password=MyMML1m4r@");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("SELECT nome_empregado, salario_empregado, idade_empregado, nome_cargo, nome_departamento FROM empregado, cargo, departamento WHERE empregado.id_cargo = cargo.id_cargo AND empregado.id_departamento = departamento.id_departamento;");

			System.out.println("Os dados dos empregados são:");

			while (rs.next()) {
				System.out.println("Nome " + rs.getString("nome_empregado") + ", Salário: " + rs.getFloat("salario_empregado") + ", Idade: " + rs.getInt("idade_empregado") + ", Cargo: " + rs.getString("nome_cargo") + ", Departamento: " + rs.getString("nome_departamento"));
			}
			
			System.out.println();
			System.out.println("O nome do empregado com id 1 é:");
			pstmt = conn.prepareStatement("SELECT nome_empregado, salario_empregado, idade_empregado, nome_cargo, nome_departamento FROM empregado, cargo, departamento WHERE empregado.id_cargo = cargo.id_cargo AND empregado.id_departamento = departamento.id_departamento AND id_empregado = ?");
			pstmt.setString(1, "1");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("Nome " + rs.getString("nome_empregado") + ", Salário: " + rs.getFloat("salario_empregado") + ", Idade: " + rs.getInt("idade_empregado") + ", Cargo: " + rs.getString("nome_cargo") + ", Departamento: " + rs.getString("nome_departamento"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {

			//após fazer a consulta devolver todas as conexões.
			try {
				if (rs != null)
					rs.close();
				
				if (pstmt != null)
					pstmt.close();
				
				if (stmt != null)
					stmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}