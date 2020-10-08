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

		// Criar alguns alunos e ordenar em ordem crescente das m�dias.

		Aluno aluno1 = new Aluno("Pedro", 9.7);
		Aluno aluno2 = new Aluno("Marcos", 9.6);
		Aluno aluno3 = new Aluno("J�lio", 9.2);
		Aluno aluno4 = new Aluno("Mateus", 9.8);
		Aluno aluno5 = new Aluno("Jo�o", 10.0);
		Aluno aluno6 = new Aluno("Jo�o", 9.0);

		turma.add(aluno1);
		turma.add(aluno2);
		turma.add(aluno3);
		turma.add(aluno4);
		turma.add(aluno5);
		turma.add(aluno6);

		// System.out.println(aluno1.compareTo(aluno2));
		// System.out.println(aluno2.compareTo(aluno1));
		// System.out.println(aluno2.compareTo(aluno2));

		System.out.println("Os alunos da turma s�o: \n");

		for (int i = 0; i < turma.size(); i++) {

			Aluno aluno = turma.get(i);
			System.out.println("O nome do aluno �: " + aluno.getNome());
			System.out.println("A m�dia do aluno �: " + aluno.getMedia());
			System.out.println();
		}

		// posso implementar numa vari�vel ou colocar direto com a declara��o new
		// NameComparator()
		// NameComparator comparator = new NameComparator();

		Collections.sort(turma);
		System.out.println("Os alunos da turma em ordem crescente de m�dias s�o: \n");

		for (int i = 0; i < turma.size(); i++) {

			Aluno aluno = turma.get(i);
			System.out.println("O nome do aluno �: " + aluno.getNome());
			System.out.println("A m�dia do aluno �: " + aluno.getMedia());
			System.out.println();
		}
		Collections.sort(turma, new MediaComparator());
		System.out.println("Os alunos da turma em ordem crescente de m�dias s�o: \n");

		for (int i = 0; i < turma.size(); i++) {

			Aluno aluno = turma.get(i);
			System.out.println("O nome do aluno �: " + aluno.getNome());
			System.out.println("A m�dia do aluno �: " + aluno.getMedia());
			System.out.println();

		}

		Collections.sort(turma, new NameComparator());
		System.out.println("Os alunos da turma em ordem crescente de nomes s�o: \n");

		for (int i = 0; i < turma.size(); i++) {

			Aluno aluno = turma.get(i);
			System.out.println("O nome do aluno �: " + aluno.getNome());
			System.out.println("A m�dia do aluno �: " + aluno.getMedia());
			System.out.println();
		}

		turma.sort(new MediaComparator());
		System.out.println("Os alunos da turma em ordem crescente das m�dias s�o: \n");

		for (int i = 0; i < turma.size(); i++) {

			Aluno aluno = turma.get(i);
			System.out.println("O nome do aluno �: " + aluno.getNome());
			System.out.println("A m�dia do aluno �: " + aluno.getMedia());
			System.out.println();
		}

		turma.sort(new NameMediaComparator());
		System.out.println("Os alunos da turma em ordem crescente dos nomes e das m�dias s�o: \n");

		for (int i = 0; i < turma.size(); i++) {
			Aluno aluno = turma.get(i);
			System.out.println("O nome do aluno �: " + aluno.getNome());
			System.out.println("A m�dia do aluno �: " + aluno.getMedia());
			System.out.println();
		}
	}
}
