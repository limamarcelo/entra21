package entities;

import java.util.ArrayList;
import java.util.List;

public class Cidade {

	private String nome;
	private ArrayList<Pessoa> habitantes;

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
	
	public boolean equals(Object objeto) {

		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		// this.getClass() ou getClass tanto faz.
		if (getClass() != objeto.getClass())
			return false;

		Cidade cidade = (Cidade) objeto;

		// comparar utilizando o equals - comparando nome e quantidade de habitantes
		if (!(getNome().equals(cidade.getNome())) && !(this.quantidadeHabitante() != cidade.quantidadeHabitante()))
			return false;
		//montar comparação equals para verificar se as cidades tem cidadãos com os nomes iguais.
		//habitantes.equals.habitante
		//for (int i=0; i <= cidade. )
		
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