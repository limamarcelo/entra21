package application;

import java.util.ArrayList;
import java.util.Collections;

import entities.Aluno;
import entities.MediaComparator;
import entities.NameComparator;
import entities.NameMediaComparator;

public class Program {

	public static void main(String[] args) {

		ArrayList<Aluno> turma = new ArrayList<Aluno>();

		// Criar alguns alunos e ordenar em ordem crescente das médias.

		Aluno aluno1 = new Aluno("Pedro", 9.7);
		Aluno aluno2 = new Aluno("Marcos", 9.6);
		Aluno aluno3 = new Aluno("Júlio", 9.2);
		Aluno aluno4 = new Aluno("Mateus", 9.8);
		Aluno aluno5 = new Aluno("João", 10.0);
		Aluno aluno6 = new Aluno("João", 9.0);

		turma.add(aluno1);
		turma.add(aluno2);
		turma.add(aluno3);
		turma.add(aluno4);
		turma.add(aluno5);
		turma.add(aluno6);

		// System.out.println(aluno1.compareTo(aluno2));
		// System.out.println(aluno2.compareTo(aluno1));
		// System.out.println(aluno2.compareTo(aluno2));

		System.out.println("Os alunos da turma são: \n");

		for (int i = 0; i < turma.size(); i++) {

			Aluno aluno = turma.get(i);
			System.out.println("O nome do aluno é: " + aluno.getNome());
			System.out.println("A média do aluno é: " + aluno.getMedia());
			System.out.println();
		}

		// posso implementar numa variável ou colocar direto com a declaração new
		// NameComparator()
		// NameComparator comparator = new NameComparator();

		Collections.sort(turma);
		System.out.println("Os alunos da turma em ordem crescente de médias são: \n");

		for (int i = 0; i < turma.size(); i++) {

			Aluno aluno = turma.get(i);
			System.out.println("O nome do aluno é: " + aluno.getNome());
			System.out.println("A média do aluno é: " + aluno.getMedia());
			System.out.println();
		}
		Collections.sort(turma, new MediaComparator());
		System.out.println("Os alunos da turma em ordem crescente de médias são: \n");

		for (int i = 0; i < turma.size(); i++) {

			Aluno aluno = turma.get(i);
			System.out.println("O nome do aluno é: " + aluno.getNome());
			System.out.println("A média do aluno é: " + aluno.getMedia());
			System.out.println();

		}

		Collections.sort(turma, new NameComparator());
		System.out.println("Os alunos da turma em ordem crescente de nomes são: \n");

		for (int i = 0; i < turma.size(); i++) {

			Aluno aluno = turma.get(i);
			System.out.println("O nome do aluno é: " + aluno.getNome());
			System.out.println("A média do aluno é: " + aluno.getMedia());
			System.out.println();
		}

		turma.sort(new MediaComparator());
		System.out.println("Os alunos da turma em ordem crescente das médias são: \n");

		for (int i = 0; i < turma.size(); i++) {

			Aluno aluno = turma.get(i);
			System.out.println("O nome do aluno é: " + aluno.getNome());
			System.out.println("A média do aluno é: " + aluno.getMedia());
			System.out.println();
		}

		turma.sort(new NameMediaComparator());
		System.out.println("Os alunos da turma em ordem crescente dos nomes e das médias são: \n");

		for (int i = 0; i < turma.size(); i++) {
			Aluno aluno = turma.get(i);
			System.out.println("O nome do aluno é: " + aluno.getNome());
			System.out.println("A média do aluno é: " + aluno.getMedia());
			System.out.println();
		}
	}
}
