package exercicios;

import java.util.Scanner;

public class Exercicio_20 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int a;

		System.out.println("O programa informar� se � par ou �mpar");

		System.out.print("Insira um n�mero inteiro: ");
		a = entrada.nextInt();

		if (a%2==0) {
			System.out.println("Este n�mero � par");
		}else {
			System.out.println("Este n�mero � �mpar");
		}

		entrada.close();

	}

}
