package exercicios;

import java.util.Scanner;

public class Exercicio_14 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int x, y, z;

		System.out.println("O programa calcular� o produto de tr�s inteiros");

		System.out.println("Insira o primeiro n�mero: ");
		x = entrada.nextInt();

		System.out.println("Insira o segundo n�mero: ");
		y = entrada.nextInt();

		System.out.println("Insira o terceiro n�mero: ");
		z = entrada.nextInt();

		int resultado = x * y * z;

		System.out.printf("O produto �: " + resultado);

		entrada.close();
	}
}