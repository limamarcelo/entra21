package AtividadeAvaliativa01;

import java.util.Scanner;

public class Questao20 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int numero;

		System.out.println("O programa informar� se o n�mero inserido � par ou �mpar");
		System.out.print("Insira um n�mero inteiro: ");
		numero = entrada.nextInt();

		if (numero % 2 == 0) {
			System.out.println("O n�mero " + numero + " � par");
		} else {
			System.out.println("O n�mero " + numero + " � �mpar");
		}
		entrada.close();
	}
}