package exercicios;

import java.util.Scanner;

public class Exercicio_19 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int valor[] = new int[5];

		System.out.println(valor.length);
		System.out.println("O programa apresentará o maior e o menor número de cinco valores informados");

		for (int i = 0; i < valor.length; i++) {
			System.out.printf("Insira o número # %d: ", (i + 1));
			valor[i] = entrada.nextInt();
			
		}
		for (int i = 0; i < valor.length; i++) {

			if (valor[i] < menor) {
				menor = valor[i];
			}
		}

		for (int i = 0; i < valor.length; i++) {
			if (valor[i] < maior) {
				maior = valor[i];
			}

			/*
			 * int menor = 0, maior=0; (Array.getInt(valor, i)<menor) {
			 * menor=Array.getInt(valor, i);
			 * 
			 * } if (Array.getInt(valor, i)<maior) { maior=Array.getInt(valor, i);
			 * 
			 * } }
			 */
			/*
			 * System.out.println("Insira o segundo número: "); b = entrada.nextInt();
			 * System.out.println("Insira o terceiro número: "); c = entrada.nextInt();
			 * System.out.println("Insira o quarto número: "); d = entrada.nextInt();
			 * System.out.println("Insira o quinto número: "); e = entrada.nextInt();
			 * 
			 * menor = a; if (b < menor) { menor = b; if (c < menor) { menor = c; if (d <
			 * menor) { menor = d; if (e < menor) { menor = e; } } } } maior = a; if (b >
			 * maior) { maior = b; if (c > maior) { maior = c; if (d > maior) { maior = d;
			 * if (e > maior) { maior = e; } } } }
			 */

			System.out.println("O menor valor informado é: " + menor);
			System.out.println("O maior valor informado é: " + maior);

			entrada.close();
		}
	}
}