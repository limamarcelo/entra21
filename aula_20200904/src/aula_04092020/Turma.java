package aula_04092020;

public class Turma {
//atributos
//composição - dependente
//associação - indepentente
	
	private String nome;
	private Professor professor;
	private Aluno [] alunos;
	
	public Turma(String nome, Professor professor) {
		setNome(nome);
		setProfessor(professor);
		alunos = new Aluno[30];
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
