package AtividadeAvaliativa01;

import java.util.Scanner;

public class Questao19 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("O programa apresentar� o maior e o menor n�mero de cinco valores informados");
		System.out.print("Informe o primeiro n�mero: ");
		int numero = entrada.nextInt();
		int menor = numero;
		int maior = numero;
		System.out.print("Informe o segundo n�mero: ");
		numero = entrada.nextInt();
		if (numero < menor) {
			menor = numero;
		}
		if (numero > maior) {
			maior = numero;
		}
		System.out.print("Informe o terceiro n�mero: ");
		numero = entrada.nextInt();
		if (numero < menor) {
			menor = numero;
		}
		if (numero > maior) {
			maior = numero;
		}
		System.out.print("Informe o quarto n�mero: ");
		numero = entrada.nextInt();
		if (numero < menor) {
			menor = numero;
		}
		if (numero > maior) {
			maior = numero;
		}
		System.out.print("Informe o quinto n�mero: ");
		numero = entrada.nextInt();
		if (numero < menor) {
			menor = numero;
		}
		if (numero > maior) {
			maior = numero;
		}
		System.out.println("O menor valor informado �: " + menor);
		System.out.println("O maior valor informado �: " + maior);

		/*
		 * // Outra forma de fazer com if
		 * 
		 * int numero1, numero2, numero3, numero4, numero5;
		 * 
		 * System.out.
		 * println("O programa apresentar� o maior e o menor n�mero de cinco valores informados"
		 * ); System.out.print("Informe o primeiro n�mero: "); numero1 =
		 * entrada.nextInt(); System.out.print("Informe o segundo n�mero: "); numero2 =
		 * entrada.nextInt(); System.out.print("Informe o terceiro n�mero: "); numero3 =
		 * entrada.nextInt(); System.out.print("Informe o quarto n�mero: "); numero4 =
		 * entrada.nextInt(); System.out.print("Informe o quinto n�mero: "); numero5 =
		 * entrada.nextInt();
		 * 
		 * menor = numero1;
		 * 
		 * if (numero2 < menor) { menor = numero2; } if (numero3 < menor) { menor =
		 * numero3; } if (numero4 < menor) { menor = numero4; } if (numero5 < menor) {
		 * menor = numero5; }
		 * 
		 * maior = numero1;
		 * 
		 * if (numero2 > maior) { maior = numero2; } if (numero3 > maior) { maior =
		 * numero3; }
		 * 
		 * if (numero4 > maior) { maior = numero4; }
		 * 
		 * if (numero5 > maior) { maior = numero5; }
		 * 
		 * System.out.println("O menor valor informado �: " + menor);
		 * System.out.println("O maior valor informado �: " + maior);
		 */

		// Havia feito com if ap�s coment�rio do professor que poderia ser feito com for
		// ent�o implementei desta forma abaixo, mas para entrega pediu para deixar com

		/*
		 * if mesmo; int valor[] = new int[5]; for (int i = 0; i < valor.length; i++) {
		 * System.out.printf("Insira o n�mero # %d: ", (i + 1)); valor[i] =
		 * entrada.nextInt(); }
		 *
		 * int menor = valor[0]; int maior = valor[0];
		 *
		 * for (int i = 0; i < valor.length; i++) { if (valor[i] < menor) { menor =
		 * valor[i]; } if (valor[i] > maior) { maior = valor[i]; } }
		 *
		 *
		 * System.out.println("O menor valor informado �: " + menor);
		 * System.out.println("O maior valor informado �: " + maior);
		 */

		entrada.close();
	}
}