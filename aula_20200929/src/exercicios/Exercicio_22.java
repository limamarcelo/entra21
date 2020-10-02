package exercicios;

import java.util.Scanner;

public class Exercicio_22 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite um n�mero inteiro com 5 d�gitos: ");

		int numero = entrada.nextInt();
		while(numero<=10000 || numero>=99999) {
			System.out.println("N�mero inv�lido!");
			System.out.print("Digite um n�mero inteiro com 5 d�gitos: ");
			numero = entrada.nextInt();	
		}
		
		char[]digitos = String.valueOf(numero).toCharArray();
		
		for (char d : digitos) {
			System.out.print(d + " ");
		}
		entrada.close();
	}
}