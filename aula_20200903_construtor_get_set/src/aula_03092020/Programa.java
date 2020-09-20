package aula_03092020;

import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		Aluno allan = new Aluno("Allan", -1);
		Scanner sc = new Scanner(System.in);

		allan.setNome(sc.nextLine());
		allan.setIdade(29);
		// allan.notas = 7;
		allan.confirmarPresenca();

		System.out.println("O nome do aluno é: " + allan.getNome());
		System.out.println("A idade do aluno é: " + allan.getIdade());
		// System.out.println("A nota do aluno é: " + allan.getNotas());
		sc.close();
	}
}