package AtividadeAvaliativa01;

import java.util.Scanner;

public class Questao17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe dois n�meros inteiros");
		int a = sc.nextInt();
		int b = sc.nextInt();

		if (a > b) {
			System.out.println(a + " � maior");
		}

		if (b > a) {
			System.out.println(b + " � maior");
		}

		if (a == b) {
			System.out.println("Esses n�meros s�o iguais");
		}
		sc.close();
	}
}