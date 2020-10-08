package application;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		ArrayList<String> palavras = new ArrayList<String>();

		System.out.println("Quantas palavras vocês deseja armazenar");
		int n = leitor.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.print("Informe a palavra #" + (i+1) + ": ");
			String palavra = leitor.next();
			palavras.add(palavra);
		}

		System.out.println("As palavras são:");
		for (String auxiliar : palavras) {
			System.out.println(auxiliar);
		}

		leitor.close();
	}
}