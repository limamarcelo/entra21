package modelo.departamento;

public class Departamento {
	//atributos
	private String nome;
	private String local;
	
	//construtor
	public Departamento(String nome, String local) {
		this.setNome(nome);
		this.setLocal(local);
	}
	
	//métodos acessores e modificadores
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getLocal() {
		return this.local;
	}
}
