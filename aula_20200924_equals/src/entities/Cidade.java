package entities;

import java.util.ArrayList;
import java.util.List;

public class Cidade {

	private ArrayList<Pessoa> habitantes;

	public Cidade() {
		habitantes = new ArrayList<Pessoa>();

	}
	/*
	 * public void adicionarHabitante (Pessoa habitante) {
	 * habitantes.add(habitante);
	 * 
	 * }
	 */

	// inclui e retorna com valor de verdadeiro ou falso se conseguiu ou não
	// incluir.
	public boolean adicionarHabitante(Pessoa habitante) {
		return habitantes.add(habitante);

	}

	public boolean removerHabitante(Pessoa habitante) {
		return habitantes.remove(habitante);

	}

	public List<Pessoa> getPessoa() {
		return habitantes;
	}

	public void addPessoa(Pessoa habitantes) {
		this.habitantes.add(habitantes);
	}

	public void removePessoa(Pessoa habitantes) {
		this.habitantes.remove(habitantes);
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
