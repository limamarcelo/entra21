package exercicios;

import java.util.Scanner;

public class Exercicio_25 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Calculadora do Índice de Massa Corpórea");
		System.out.print("Digite o peso: ");
		double peso = sc.nextDouble();
		System.out.print("Digite sua altura em metros: ");
		double altura = sc.nextDouble();

		double IMC = peso / Math.pow(altura, 2);
		System.out.printf("Seu IMC é de: %.2f\n" , IMC);

		double diferencaMinimo;
		
		if (IMC < 18.5) {
			System.out.println("Abaixo do peso");
			diferencaMinimo = 62 - peso;
			System.out.printf("Seu peso deveria ser no mínimo 62kg, você precisa ganhar %.3fkg." , diferencaMinimo);
		}
		
		if (IMC >= 18.5 && IMC <= 24.9) {
			System.out.println("Peso normal");
			System.out.printf("Parabéns seu peso está dentro do adequado. O seu peso pode variar entre 62kg e 83kg.");	
		}
		
		if (IMC > 24.9 && IMC <= 29.9) {
			System.out.println("Acima do peso");
			diferencaMinimo = peso-83.4;
			System.out.printf("Seu peso ideal pode variar entre 62kg e 83kg, você deveria emagrecer no mínimo %.3fkg." , diferencaMinimo);
		}
		
		if (IMC > 29.9) {
			System.out.println("Obeso");
			diferencaMinimo = peso-83.4;
			System.out.printf("Seu peso ideal pode variar entre 62kg e 83kg, você deveria emagrecer no mínimo %.3fkg." , diferencaMinimo);
		}
		
		sc.close();

		// https://bvsms.saude.gov.br/bvs/dicas/215_obesidade.html }
	}
}