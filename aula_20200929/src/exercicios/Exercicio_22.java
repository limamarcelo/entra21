package exercicios;

import java.util.Scanner;

public class Exercicio_22 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite um número inteiro com 5 dígitos: ");

		int numero = entrada.nextInt();
		while(numero<=10000 || numero>=99999) {
			System.out.println("Número inválido!");
			System.out.print("Digite um número inteiro com 5 dígitos: ");
			numero = entrada.nextInt();	
		}
		
		char[]digitos = String.valueOf(numero).toCharArray();
		
		for (char d : digitos) {
			System.out.print(d + " ");
		}
		entrada.close();
	}
}