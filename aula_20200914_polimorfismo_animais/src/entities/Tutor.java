package entities;

public class Tutor {

	private String nome;

	public Tutor(String nome) {
		setTutor(nome);
	}

	public void setTutor(String nome) {
		this.nome = nome;
	}

	public String getTutor() {
		return nome;
	}
}