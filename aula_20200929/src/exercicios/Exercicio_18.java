package exercicios;

import java.util.Scanner;

public class Exercicio_18 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int x, y, z, maior, menor, produto, media, soma;

		System.out.println("Insira o primeiro n�mero: ");
		x = entrada.nextInt();

		System.out.println("Insira o segundo n�mero: ");
		y = entrada.nextInt();

		System.out.println("Insira o terceiro n�mero: ");
		z = entrada.nextInt();

		soma = x + y + z;
		media = (x + y + z) / 3;
		produto = x * y * z;
		if (x < y) {
			menor = x;
		} else {
			if (z < x) {
				menor = z;
			} else {
				menor = y;
			}
		}

		if (x > y) {
			maior = x;
		} else {
			if (y > z) {
				maior = y;
			} else {
				maior = z;
			}
		}
		
		System.out.println("A soma dos valores informados �: " + soma);
		System.out.println("A m�dia dos valores informados �: " + media);
		System.out.println("O produto dos valores informados �: " + produto);
		System.out.println("O menor valor informado �: " + menor);
		System.out.println("O maior valor informado �: " + maior);

		entrada.close();

	}

}
