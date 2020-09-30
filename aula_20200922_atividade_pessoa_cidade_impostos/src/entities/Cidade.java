package entities;

import java.util.ArrayList;

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
	 //Somente inclui o habitante sem retornar o resultado se conseguiu ou não incluir no array.
	 
	 public void adicionarHabitante (Pessoa habitante) {
	 habitantes.add(habitante);
	 
	 }
	 */

	// inclui e retorna com valor de verdadeiro ou falso se conseguiu ou não
	// incluir.
	public boolean adicionarHabitante(Pessoa habitante) {
		return habitantes.add(habitante);

	}

	public boolean removerHabitante(Pessoa habitante) {
		return habitantes.remove(habitante);

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
}