package aula20200929_exercicio_16;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o valor de dois n�meros inteiros");
		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.printf("A soma dos valores %d e %d � de: %d%n", a, b, (a + b));
		System.out.printf("O produto dos valores %d e %d � de: %d%n", a, b, (a * b));
		System.out.printf("A diferen�a entre os valores %d e %d � de: %d%n", a, b, (a - b));
		System.out.printf("O quociente entre os valores %d e %d � de: %d%n", a, b, (a / b));

		sc.close();
	}

}
