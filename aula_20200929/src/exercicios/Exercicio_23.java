package exercicios;

public class Exercicio_23 {

	public static void main(String[]args) {
		System.out.println("O programa calculará o quadrado de todos os números inteiros de 0 - 10");
		
		for(int i=0;i<=10;i++) {
			double numero = Math.pow(i, 2);
			System.out.println("O quadrado de "+ i + " é = " + numero);
		}
		System.out.println("O programa calculará o cubo de todos os números inteiros de 0 - 10");

		for(int i=0;i<=10;i++) {
			double numero = Math.pow(i, 3);
			System.out.println("O cubo de "+ i + " é = " + numero);
		}

	}
}
