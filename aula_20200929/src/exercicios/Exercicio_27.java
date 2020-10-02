package exercicios;

import java.util.Scanner;

public class Exercicio_27 {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
	System.out.println("Programa Carona Solidária");	
	System.out.print("Qual o seu delocamento diário em KM: ");
	int km = sc.nextInt();
	System.out.print("Qual a média de consumo do combustível por km do seu veículo: ");
	float media = sc.nextFloat();
	System.out.print("Qual o valor por litro do combustível: R$ ");
	float combustivel = sc.nextFloat();
	float custo = km / media * combustivel;
	System.out.printf("O custo para o trajeto é de: R$%.2f\n", custo);
	
	System.out.printf("Caso você divida sua despesa com mais uma pessoa a sua economia seria de: R$%.2f\n", custo - custo / 2);
	System.out.printf("Caso você divida sua despesa com mais duas pessoas a sua economia seria de: R$%.2f\n", custo - custo / 3);
	System.out.printf("Caso você divida sua despesa com mais três pessoas a sua economia seria de: R$%.2f\n", custo - custo / 4);
	System.out.printf("Caso você divida sua despesa com mais quatro pessoas a sua economia seria de: R$%.2f\n", custo - custo / 5);
	
	sc.close();
	}
}