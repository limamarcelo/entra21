package AtividadeAvaliativa01;

import java.util.Scanner;

public class Questao20 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int numero;

		System.out.println("O programa informará se o número inserido é par ou ímpar");
		System.out.print("Insira um número inteiro: ");
		numero = entrada.nextInt();

		if (numero % 2 == 0) {
			System.out.println("O número " + numero + " é par");
		} else {
			System.out.println("O número " + numero + " é ímpar");
		}
		entrada.close();
	}
}