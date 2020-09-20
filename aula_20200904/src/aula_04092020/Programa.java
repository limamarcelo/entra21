package aula_04092020;

import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Vamos criar uma turma");
		System.out.println("Informe o nome da turma: ");
		String nomeTurma = sc.nextLine();

		System.out.println("Informe o nome do professor: ");
		String nomeProfessor = sc.nextLine();

		System.out.println("Informe a idade do professor: ");
		int idadeProfessor = sc.nextInt();

		Professor professor = new Professor(nomeProfessor, idadeProfessor);

		Turma turma = new Turma(nomeTurma, professor);

		System.out.println("O nome da turma é: " + turma.getNome());
		System.out.println("O nome do professor da turma é: " + professor.getNome());
		System.out.println("A idade do professor é: " + professor.getIdade());

		sc.close();
	}
}