package exercicios;

import java.util.Scanner;

public class Exercicio_14 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int x, y, z;

		System.out.println("O programa calculará o produto de três inteiros");

		System.out.println("Insira o primeiro número: ");
		x = entrada.nextInt();

		System.out.println("Insira o segundo número: ");
		y = entrada.nextInt();

		System.out.println("Insira o terceiro número: ");
		z = entrada.nextInt();

		int resultado = x * y * z;

		System.out.printf("O produto é: " + resultado);

		entrada.close();
	}
}