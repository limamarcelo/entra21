package AtividadeAvaliativa01;

import java.util.Locale;
import java.util.Scanner;

public class Questao24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		int numero1, numero2, numero3, numero4, numero5;
		int zero = 0;
		int negativo = 0;
		int positivo = 0;
		// Na correção o professor sugeriu retirar o último if pois não havia
		// necessidade. OK.
		System.out.println("Digite cinco números inteiros");
		System.out.print("Digite o #1: ");
		numero1 = sc.nextInt();
		if (numero1 == 0) {
			zero += 1;
		} else {
			if (numero1 > 0) {
				positivo += 1;
			} else {
				negativo += 1;
			}
		}
		/*
		 * else { if (numero1 < 0) { } } }
		 */
		System.out.print("Digite o #2: ");
		numero2 = sc.nextInt();
		if (numero2 == 0) {
			zero += 1;
		} else {
			if (numero2 > 0) {
				positivo += 1;
			} else {
				negativo += 1;
			}
		}
		/*
		 * else { if (numero2 < 0) { negativo += 1; } } }
		 */
		System.out.print("Digite o #3: ");
		numero3 = sc.nextInt();
		if (numero3 == 0) {
			zero += 1;
		} else {
			if (numero3 > 0) {
				positivo += 1;
			} else {
				negativo += 1;
			}
		}

		/*
		 * else { if (numero3 < 0) { } } }
		 */

		System.out.print("Digite o #4: ");
		numero4 = sc.nextInt();
		if (numero4 == 0) {
			zero += 1;
		} else {
			if (numero4 > 0) {
				positivo += 1;
			} else {
				negativo += 1;
			}
		}

		/*
		 * else { if (numero4 < 0) { negativo += 1; } } }
		 */
		System.out.print("Digite o #5: ");
		numero5 = sc.nextInt();
		if (numero5 == 0) {
			zero += 1;
		} else {
			if (numero5 > 0) {
				positivo += 1;
			} else {
				negativo += 1;
			}
		}
		/*
		 * else { if (numero5 < 0) { negativo += 1; } } }
		 */

		System.out.println("Quantidade de número zero = " + zero);
		System.out.println("Quantidade de números positivos = " + positivo);
		System.out.println("Quantidade de números negativos = " + negativo);

		// Havia feito o exercicio com vetor e for mas o professor pediu para utilizar
		// apenas if.
		/*
		 * int numero[] = new int[5]; int negativo = 0; int positivo = 0; int zero = 0;
		 * System.out.println("Digite cinco números inteiros"); for (int i = 0; i <
		 * numero.length; i++) { System.out.print("Digite o #" + (i + 1) + " :");
		 * numero[i] = sc.nextInt(); if (((numero[i]) == 0)) { zero += 1; } if
		 * (numero[i] > 0) { positivo += 1; } if (numero[i] < 0) { negativo += 1; } }
		 * System.out.println("Quantidade de número zero = " + zero);
		 * System.out.println("Quantidade de números positivos = " + positivo);
		 * System.out.println("Quantidade de números negativos = " + negativo);
		 */
		sc.close();
	}
}