package exercicios;

import java.util.Scanner;

public class Exercicio_26 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Insira os dados para c�lculo de estimativa de crescimento populacional");
		System.out.println("Qual a popula��o de pessoas atual no planeta? (Em bilh�es, por exemplo 7,594)");
		double populacao = sc.nextDouble();
		System.out.println("Qual a taxa crescimento da popula��o? ");
		Double taxa = sc.nextDouble();
		
		//primeiro ano
		populacao += populacao*taxa/100;
		System.out.printf("Estimativa de crescimento da popula��o ap�s um ano: %.3f\n" , populacao);
		
		//segundo ano
		populacao += populacao*taxa/100;
		System.out.printf("Estimativa de crescimento da popula��o ap�s dois anos: %.3f\n" , populacao);

		//terceiro ano
		populacao += populacao*taxa/100;
		System.out.printf("Estimativa de crescimento da popula��o ap�s tr�s anos: %.3f\n" , populacao);

		//quarto ano
		populacao += populacao*taxa/100;		
		System.out.printf("Estimativa de crescimento da popula��o ap�s quatro anos: %.3f\n" , populacao);
		
		//quinto ano
		populacao += populacao*taxa/100;		
		System.out.printf("Estimativa de crescimento da popula��o ap�s cinco anos: %.3f\n" , populacao);

		sc.close();
		// taxa de crescimento da popula��o 1,1% mudan�a anual (2018)
		// https://www.google.com/search?q=popula%C3%A7%C3%A3o+atual+do+planeta&oq=popula%C3%A7%C3%A3o+atual+do+planeta&aqs=chrome..69i57j0l7.8749j0j7&sourceid=chrome&ie=UTF-8
	}
}