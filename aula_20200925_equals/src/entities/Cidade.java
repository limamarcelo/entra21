package entities;

import java.util.ArrayList;
import java.util.List;

public class Cidade {

	private String nome;
	private ArrayList<Pessoa> habitantes;
	private ArrayList<Estado> estados;
	private ArrayList<Pais> paises;

	public Cidade(String nome) {
		setNome(nome);
		habitantes = new ArrayList<Pessoa>();
		estados = new ArrayList<Estado>();
		paises = new ArrayList<Pais>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*
	 * public void adicionarHabitante (Pessoa habitante) {
	 * habitantes.add(habitante); }
	 */
	// inclui e retorna com valor de verdadeiro ou falso se conseguiu ou não
	// incluir.
	public boolean adicionarHabitante(Pessoa habitante) {
		return habitantes.add(habitante);
	}

	public boolean removerHabitante(Pessoa habitante) {
		return habitantes.remove(habitante);
	}

	public int quantidadeHabitante() {
		return habitantes.size();
	}
	
	public List<Pessoa> getPessoa() {
		return habitantes;
	}

	// void fica sem retorno para saber se conseguiu ou não adicionar, retirado
	/*
	 * public void addPessoa(Pessoa habitantes) { this.habitantes.add(habitantes); }
	 * 
	 * public void removePessoa(Pessoa habitantes) {
	 * this.habitantes.remove(habitantes); }
	 */

	public List<Estado> getEstado() {
		return estados;
	}

	public List<Pais> getPais() {
		return paises;
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

	public double calcularArrecadacao() {

		double totalArrecadado = 0;
		Pessoa habitante = null;

		for (int i = 0; i < habitantes.size(); i++) {
			habitante = habitantes.get(i);
			totalArrecadado += habitante.calcularImposto();
		}
		
		return totalArrecadado;
	}

	public String toString() {
		return nome;
	}
}