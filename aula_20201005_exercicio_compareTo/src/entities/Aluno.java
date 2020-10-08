package entities;

import java.util.ArrayList;

public class Aluno {

	private String nome;
	private float idade;
	private ArrayList<Aluno> notas = new ArrayList<>();

	public Aluno() {
	}

	public Aluno(String nome, float idade, ArrayList<Aluno> nota) {
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

	public ArrayList<Aluno> getNota() {
		return this.notas;
	}

	public void addNota(Aluno nota) {
		this.notas.add(nota);
	}

	public void removeNota(Aluno nota) {
		this.notas.remove(nota);
	}

	/*
	 * public String toString(int j) { return "Nome do aluno " + nome + ", idade " +
	 * idade + ", notas"; } 
	 * }
	 */

	@Override
	public int compareTo(Pessoa pessoa) {

		if (this.getMedia() < pessoa.getMedia())
			return -1;

		if (this.getNome().compareTo(nome) < pessoa.compareTo(pessoa) && this.getIdade() > pessoa.getIdade())
			return 1;
		return 0;
	}

}