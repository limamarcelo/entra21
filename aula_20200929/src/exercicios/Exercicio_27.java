package exercicios;

import java.util.Scanner;

public class Exercicio_27 {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
	System.out.println("Programa Carona Solid�ria");	
	System.out.print("Qual o seu delocamento di�rio em KM: ");
	int km = sc.nextInt();
	System.out.print("Qual a m�dia de consumo do combust�vel por km do seu ve�culo: ");
	float media = sc.nextFloat();
	System.out.print("Qual o valor por litro do combust�vel: R$ ");
	float combustivel = sc.nextFloat();
	float custo = km / media * combustivel;
	System.out.printf("O custo para o trajeto � de: R$%.2f\n", custo);
	
	System.out.printf("Caso voc� divida sua despesa com mais uma pessoa a sua economia seria de: R$%.2f\n", custo - custo / 2);
	System.out.printf("Caso voc� divida sua despesa com mais duas pessoas a sua economia seria de: R$%.2f\n", custo - custo / 3);
	System.out.printf("Caso voc� divida sua despesa com mais tr�s pessoas a sua economia seria de: R$%.2f\n", custo - custo / 4);
	System.out.printf("Caso voc� divida sua despesa com mais quatro pessoas a sua economia seria de: R$%.2f\n", custo - custo / 5);
	
	sc.close();
	}
}