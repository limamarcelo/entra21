package modelo.dao.departamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.departamento.Departamento;

public class DepartamentoDAOSGBDImpl implements DepartamentoDAO{
	
	public void inserirDepartamento(Departamento departamento){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?useTimezone=true&serverTimezone=UTC&user=root&password=27021991");
			pstmt = conn.prepareStatement("INSERT INTO departamento (nome_departamento, local_departamento) VALUES (?,?)");
	        
	        pstmt.setString(1, departamento.getNome());
	        pstmt.setString(2, departamento.getLocal());

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
	
	public void removerDepartamentoPeloNome(String nomeDepartamento){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?useTimezone=true&serverTimezone=UTC&user=root&password=27021991");
			pstmt = conn.prepareStatement("DELETE FROM departamento WHERE nome_departamento = ?");
	        
	        pstmt.setString(1, nomeDepartamento);

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
	
	public void editarDepartamentoPeloNome(String nomeAntigo, String nomeNovo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?useTimezone=true&serverTimezone=UTC&user=root&password=27021991");
			pstmt = conn.prepareStatement("UPDATE departamento set nome_departamento = ? WHERE nome_departamento = ?");
	        
	        pstmt.setString(1, nomeNovo);
	        pstmt.setString(2, nomeAntigo);

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
	
	public void listarDepartamentos(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?useTimezone=true&serverTimezone=UTC&user=root&password=27021991");        
	        
	        stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT nome_departamento, local_departamento FROM departamento");

            while (rs.next()) {
                System.out.println(rs.getString("nome_departamento") + " - " + rs.getString("local_departamento"));
            }

	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    } finally {
	    	
	        try {
	        	
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
