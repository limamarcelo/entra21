package AtividadeAvaliativa01;

import java.util.Scanner;

public class Questao21 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int a, b;

		System.out.println("O programa informar� se o primeiro n�mero � m�ltiplo do segundo");

		System.out.print("Insira o primeiro n�mero inteiro: ");
		a = entrada.nextInt();

		System.out.print("Insira o segundo n�mero inteiro: ");
		b = entrada.nextInt();

		if (a % b == 0) {
			System.out.println("O primeiro n�mero informado � m�ltiplo do segundo n�mero");
		} else {
			System.out.println("O primeiro n�mero informado n�o � m�ltiplo do segundo n�mero");
		}
		entrada.close();
	}
}