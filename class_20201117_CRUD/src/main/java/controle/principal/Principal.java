package controle.principal;
import modelo.dao.departamento.DepartamentoDAO;
import modelo.dao.departamento.DepartamentoDAOSGBDImpl;
import modelo.departamento.Departamento;

public class Principal {

	public static void main(String[] args) {
		
		DepartamentoDAO dao = new DepartamentoDAOSGBDImpl();
		
		//inserir
		//dao.inserirDepartamento(new Departamento("Financeiro", "Blumenau"));
		
		//editar
		//dao.editarDepartamentoPeloNome("Financeiro", "Compras");
		
		//deletar
		//dao.removerDepartamentoPeloNome("Compras");
		
		//listar
		dao.listarDepartamentos();
		
	}
}
