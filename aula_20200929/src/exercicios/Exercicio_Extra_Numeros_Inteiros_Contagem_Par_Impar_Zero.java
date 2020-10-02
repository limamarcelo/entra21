package exercicios;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio_Extra_Numeros_Inteiros_Contagem_Par_Impar_Zero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		int numero[] = new int[5];
		int par = 0;
		int impar = 0;
		int zero = 0;
		System.out.println("Digite cinco números inteiros");
		for (int i = 0; i < numero.length; i++) {
			System.out.print("Digite o #" + (i + 1) + " :");
			numero[i] = sc.nextInt();
			if (((numero[i]) == 0)) {
				zero += 1;
			}
			if ((numero[i] != 0) && ((numero[i]) % 2) == 0) {
				par += 1;
			}
			if (((numero[i]) % 2) == 1) {
				impar += 1;
			}
		}
		System.out.println("Quantidade de zeros = " + zero);
		System.out.println("Quantidade de números pares = " + par);
		System.out.println("Quantidade de números ímpares = " + impar);
		sc.close();
	}
}
