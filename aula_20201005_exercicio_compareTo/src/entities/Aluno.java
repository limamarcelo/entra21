package entities;

import java.util.ArrayList;

public class Aluno {

	private String nome;
	private float idade;
	private ArrayList<Float> notas = new ArrayList<Float>();

	public Aluno() {
	}

	public Aluno(String nome, float idade, ArrayList<Float> nota) {
		this.nome = nome;
		this.idade = idade;
		this.notas = nota;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getIdade() {
		return this.idade;
	}

	public void setIdade(float idade) {
		this.idade = idade;
	}

	public ArrayList<Float> getNota() {
		return this.notas;
	}

	public void addNota(Float nota) {
		this.notas.add(nota);
	}

	public void removeNota(Float nota) {
		this.notas.remove(nota);
	}

	/*
	 * public String toString(int j) { return "Nome do aluno " + nome + ", idade " +
	 * idade + ", notas"; } }
	 */

	public float media() {
		float sum = 0;

		for (int i = 0; i < notas.size(); i++) {
			float nota = notas.get(i);
			sum += nota;
		}
		return sum / notas.size();
	}
}