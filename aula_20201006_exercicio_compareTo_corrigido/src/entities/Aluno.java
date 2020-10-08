package entities;

public class Aluno implements Comparable<Aluno>{

	private String nome;
	private double media;

	public Aluno() {
	}

	public Aluno(String nome, double media) {
		this.nome = nome;
		this.media = media;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getMedia() {
		return this.media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
/*
	public int compareTo(Aluno aluno) {

		if (this.getMedia() > aluno.getMedia())
			return 1;

		if (this.getMedia() < aluno.getMedia())
			return -1;

		return 0;
	}
*/
	
	public int compareTo(Aluno aluno) {

		if (this.getMedia() > aluno.getMedia())
			return 1;

		if (this.getMedia() < aluno.getMedia())
			return -1;
		
		return 0;
	}	
}