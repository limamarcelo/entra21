package exercicios;

import java.util.Scanner;

public class Exercicio_25 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Calculadora do Índice de Massa Corpórea");
		System.out.print("Digite o peso: ");
		float peso = sc.nextFloat();
		System.out.print("Digite sua altura: ");
		float altura = sc.nextFloat();
		
		double IMC = peso / Math.pow(altura, 2);
		System.out.println("Seu IMC é: " + IMC);
		
		if(IMC<18.5) {
			System.out.println("Magreza");
		}
		if(IMC>=18.5 && IMC <=24.9) {
			System.out.println("Normal");
		}
		if(IMC>=25 && IMC <=29.9) {
			System.out.println("Sobrepeso");
		}
		if(IMC>=30 && IMC <=39.9) {
			System.out.println("Obesidade");
		}
		if(IMC>=40) {
			System.out.println("Obesidade II");
		}
		
		sc.close();
		
		//https://www.programasaudefacil.com.br/calculadora-de-imc
	}

}
