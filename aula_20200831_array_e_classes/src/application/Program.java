package application;

import entities.Alunos;

class Program {
	public static void main(String[] args) {

		Alunos allan = new Alunos();

		allan.nome = "Allan";
		allan.idade = 29;
		float nota = 10;
		allan.nota = new float [1];
		allan.nota[0] = nota;
		allan.confirmarPresenca();

		System.out.println("O nome do aluno �: " + allan.nome);
		System.out.println("A idade do aluno �: " + allan.idade);
		System.out.println("A nota do aluno �: " + allan.nota[0]);

	}
}