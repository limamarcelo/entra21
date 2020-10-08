package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import entities.Aluno;
import entities.Nota;

public class Program {

	public static void main(String[] args) {

		// Criar alguns alunos e ordenar em ordem crescente das médias.

		Scanner sc = new Scanner(System.in);
		ArrayList<Aluno> alunos = new ArrayList<>();
		ArrayList<Nota> notas = new ArrayList<>();
		System.out.print("Quantos alunos você deseja cadastrar? ");
		int n = sc.nextInt();
		System.out.print("Quantas notas você deseja cadastrar para cada aluno: ");
		int qtdNotas = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.print("Informe o nome do aluno #" + (i + 1) + ": ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Informe a idade do aluno #" + (i + 1) + ": ");
			int idade = sc.nextInt();

			for (int j = 0; j < qtdNotas; j++) {
				System.out.print("Informe a nota #" + (j + 1) + ": ");
				float nota = sc.nextFloat();
				notas.add(nota);
			}
			Aluno aluno = new Aluno(nome, idade, new ArrayList<Aluno>(nota));
			alunos.add(aluno);

		}

		for (Aluno x : alunos) {
			for (int i = 0; i <= alunos.size(); i++) {

				System.out.println("Nome do aluno" + x.getNome() + ", idade " + x.getIdade() + ", notas "
						+ (x.getNota().get(i).getNota()));
			}
		}
		sc.close();
	}

}
