package exercicios;

import java.util.Scanner;

public class Exercicio_20 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int a;

		System.out.println("O programa informará se é par ou ímpar");

		System.out.print("Insira um número inteiro: ");
		a = entrada.nextInt();

		if (a%2==0) {
			System.out.println("Este número é par");
		}else {
			System.out.println("Este número é ímpar");
		}

		entrada.close();

	}

}
