package AtividadeAvaliativa01;

import java.util.Scanner;

public class Questao17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe dois números inteiros");
		int a = sc.nextInt();
		int b = sc.nextInt();

		if (a > b) {
			System.out.println(a + " é maior");
		}

		if (b > a) {
			System.out.println(b + " é maior");
		}

		if (a == b) {
			System.out.println("Esses números são iguais");
		}
		sc.close();
	}
}