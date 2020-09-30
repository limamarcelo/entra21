package exercicios;

import java.util.Scanner;

public class Exercicio_21 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int a, b;

		System.out.println("O programa informará se é par ou ímpar");

		System.out.print("Insira o primeiro número inteiro: ");
		a = entrada.nextInt();

		System.out.print("Insira o segundo número inteiro: ");
		b = entrada.nextInt();

		if (a%b==0) {
			System.out.println("O primeiro número informado é múltiplo do segundo número");
		}else {
			System.out.println("O primeiro número informado não é múltiplo do segundo número");
		}
		entrada.close();
	}
}