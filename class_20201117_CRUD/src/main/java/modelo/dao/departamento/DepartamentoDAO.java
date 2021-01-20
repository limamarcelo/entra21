package modelo.dao.departamento;

import modelo.departamento.Departamento;

public interface DepartamentoDAO {
	
	void inserirDepartamento(Departamento departamento);
	
	void listarDepartamentos();
	
	void removerDepartamentoPeloNome(String nomeDepartamento);
	
	void editarDepartamentoPeloNome(String nomeAntigo, String nomeNovo);
}
