package entities;

public abstract class Pessoa {

	private String nome;
	private double provento;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, double provento) {
		setNome(nome);
		setProvento(provento);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getProvento() {
		return this.provento;
	}

	public void setProvento(double provento) {
		this.provento = provento;
	}
	
	public abstract double calcularImposto();
	
	public boolean equals(Object objeto) {

		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		// this.getClass() ou getClass tanto faz.
		if (getClass() != objeto.getClass())
			return false;

		Pessoa pessoa = (Pessoa) objeto;

		// Abaixo n�o d� para comparar com != o cnpj pois o pessoa.getCnpj() � do tipo
		// PessoaJuridica e o outro uma String n�o do tipo primitivo ent�o tem que
		// comparar String utilizando o equals
		// comparar tipo primitivo utilizando o ==

		if (!(getNome().equals(pessoa.getNome())) && !(getProvento() == (pessoa.getProvento())))
			return false;

		return true;
	}
	public String toString() {
		return 	nome
				+", Provento: "
				+ provento; 
	}
	
}