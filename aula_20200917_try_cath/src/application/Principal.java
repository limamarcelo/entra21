package application;

import java.util.Locale;
import java.util.Scanner;

import entities.FiguraGeometrica;
import entities.Quadrado;

public class Principal {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			FiguraGeometrica figura = null;
			figura.calcularArea();

			try {
				int array[] = new int[10];
				array[40] = 90;

			}
			// catch caso der erro no try superior
			catch (ArrayIndexOutOfBoundsException execao) {
				System.out.println("Deu erro ao acessar o indice do array.");
			}

		} catch (NullPointerException execao) {
			System.out.println("Deu erro ao acessar o objeto nulo.");

		}
		// se meu try não der erro eu continuo a execução
		finally {
			System.out.println("Finalmente entrou");
		}
		System.out.println();
		
		
		System.out.println("Informe o lado A do Quadrado: ");
		double ladoA = sc.nextDouble();

		FiguraGeometrica quadrado = new Quadrado(ladoA);
				
		System.out.println(quadrado);
		//substituido pelo toString padrão
		//System.out.println("O quadrado com lado A: " + ((Quadrilatero) quadrado).getLadoA() + ", tem a área de: " + areaQuadrado);

		sc.close();
	}
}