package entities;

import java.util.ArrayList;


public class Cidade {

	private ArrayList<Pessoa> habitantes;
	private String nome;

	public Cidade(String nome) {
		setNome(nome);
		habitantes = new ArrayList<Pessoa>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Pessoa> getPessoas() {
		return habitantes;
	}

	public void addPessoa(Pessoa habitante) {
		this.habitantes.add(habitante);
	}

	public void removePessoa(Pessoa habitante) {
		this.habitantes.remove(habitante);
	}

	public double calcularArrecadacao() {

		double totalArrecadado = 0;
		Pessoa habitante = null;

		for (int i = 0; i < habitantes.size(); i++) {
			habitante = habitantes.get(i);
			totalArrecadado += habitante.calcularImposto();
		}

		return totalArrecadado;
	}

	public boolean equals(Object objeto) {

		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		// this.getClass() ou getClass tanto faz.
		if (getClass() != objeto.getClass())
			return false;

		Cidade cidade = (Cidade) objeto;

		// Abaixo não dá para comparar com != o cnpj pois o pessoa.getCnpj() é do tipo
		// PessoaJuridica e o outro uma String não do tipo primitivo então tem que
		// comparar utilizando o equals
		if (!(getNome().equals(cidade.getNome())))
			return false;

		return true;
	}
}
