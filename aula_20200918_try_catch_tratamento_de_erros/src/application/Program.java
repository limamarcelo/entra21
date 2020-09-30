package application;

import java.util.Locale;
import java.util.Scanner;

import entities.FiguraGeometrica;
import entities.Paralelograma;
import entities.Quadrado;
import entities.Retangulo;
import entities.TrapezioEscaleno;
import entities.TrapezioIsosceles;
import entities.Triangulo;
import execptions.LadoInvalidoException;

public class Program {

	public static void main(String[] args) throws LadoInvalidoException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Vamos aprender um pouco de geometria");
		System.out.println();

		/*
		 * // exemplo abaixo não entra pois o erro seria de Array e não de Null.
		 * 
		 * System.out.println("Primeiro try");
		 * 
		 * try { int array[] = new int[10]; array[40] = 90;
		 * 
		 * } // catch caso der erro no try superior catch (NullPointerException execao)
		 * { System.out.println("Deu erro ao acessar o indice do array."); }
		 * 
		 * System.out.println(); System.out.println("Segundo try");
		 * 
		 * try { FiguraGeometrica figura = null; figura.calcularArea();
		 * 
		 * try { int array[] = new int[10]; array[1000] = 90;
		 * 
		 * } // catch caso der erro no try superior catch
		 * (ArrayIndexOutOfBoundsException execao) {
		 * System.out.println("Deu erro ao acessar o indice do array.");
		 * System.out.println(); }
		 * 
		 * } catch (NullPointerException execao) {
		 * System.out.println("Deu erro ao acessar o objeto nulo.");
		 * System.out.println();
		 * 
		 * } // se meu try não der erro eu continuo a execução finally {
		 * System.out.println("Finalmente entrou com o finally"); System.out.println();
		 * }
		 * 
		 * System.out.println("Terceiro try"); try { FiguraGeometrica figura = null;
		 * figura.calcularArea();
		 * 
		 * try { int array[] = new int[10]; array[40] = 90;
		 * 
		 * } // catch caso der erro no try superior catch (NullPointerException execao)
		 * { System.out.println("Deu erro ao acessar o indice do array.");
		 * System.out.println(); }
		 * 
		 * } catch (ArrayIndexOutOfBoundsException execao) {
		 * System.out.println("Deu erro ao acessar o objeto nulo."); }
		 * 
		 * catch (NullPointerException execao) {
		 * System.out.println("Deu erro ao acessar o objeto nulo.");
		 * System.out.println();
		 * 
		 * } // se meu try não der erro eu continuo a execução finally {
		 * System.out.println("Finalmente entrou no finally"); }
		 * 
		 * System.out.println("Quarto try"); try { FiguraGeometrica figura = null;
		 * figura.calcularArea();
		 * 
		 * try { int array[] = new int[10]; array[40] = 90;
		 * 
		 * } // catch caso der erro no try superior catch
		 * (ArrayIndexOutOfBoundsException execao) {
		 * System.out.println("Deu erro ao acessar o indice do array.");
		 * System.out.println(); }
		 * 
		 * } catch (ArrayIndexOutOfBoundsException execao) {
		 * System.out.println("Deu erro ao acessar o objeto nulo.");
		 * System.out.println(); } // se meu try não der erro eu continuo a execução
		 * finally { System.out.println("Finalmente entrou no finally"); }
		 * System.out.println();
		 */
		double ladoA, ladoB, ladoC, ladoD, altura;

		System.out.println();
		System.out.println("Informe o lado A do Quadrado: ");
		ladoA = sc.nextDouble();
		FiguraGeometrica quadrado;
		try {
			quadrado = new Quadrado(ladoA);
			System.out.println(quadrado);

			System.out.println();
			System.out.println(((Quadrado) quadrado).stringPerimetroQuadrado());

		} catch (LadoInvalidoException exception) {
			System.out.println(exception.getMessage());

		}

		System.out.println("------------------");

		System.out.println("Informe o lado A do Retângulo: ");
		ladoA = sc.nextDouble();
		System.out.println("Informe o lado B do Retângulo: ");
		ladoB = sc.nextDouble();

		FiguraGeometrica retangulo;
		try {
			retangulo = new Retangulo(ladoA, ladoB);
			System.out.println(retangulo);

			System.out.println();
			System.out.println(((Retangulo) retangulo).stringPerimetro());

		} catch (LadoInvalidoException exception) {
			System.out.println(exception.getMessage());

		}

		System.out.println("------------------");

		System.out.println("Informe o lado A do Paralelograma: ");
		ladoA = sc.nextDouble();
		System.out.println("Informe o lado B do Retângulo: ");
		ladoB = sc.nextDouble();

		FiguraGeometrica paralelograma;
		try {
			paralelograma = new Paralelograma(ladoA, ladoB);
			System.out.println(paralelograma);

			System.out.println();
			System.out.println(((Retangulo) paralelograma).stringPerimetro());

		} catch (LadoInvalidoException exception) {
			System.out.println(exception.getMessage());

		}

		System.out.println("------------------");

		System.out.println("Informe o tamanho dos lados do Trapezio Isósceles: ");
		ladoA = sc.nextDouble();
		System.out.println("Informe a Base Maior do Trapezio Isósceles: ");
		ladoB = sc.nextDouble();
		System.out.println("Informe a Base Menor do Trapezio Isósceles: ");
		ladoD = sc.nextDouble();
		System.out.println("Informe a altura do Trapezio Isósceles: ");
		altura = sc.nextDouble();

		FiguraGeometrica trapezioIsosceles;
		try {
			trapezioIsosceles = new TrapezioIsosceles(ladoA, ladoB, ladoA, ladoD, altura);
			System.out.println(trapezioIsosceles);

			System.out.println();
			System.out.println(((TrapezioIsosceles) trapezioIsosceles).stringPerimetro());

		} catch (LadoInvalidoException exception) {
			System.out.println(exception.getMessage());

		}

		System.out.println("------------------");

		System.out.println("Informe o tamanho do lado A do Trapezio Escaleno: ");
		ladoA = sc.nextDouble();
		System.out.println("Informe a Base Maior do Trapezio Escaleno: ");
		ladoB = sc.nextDouble();
		System.out.println("Informe o tamanho do lado B do Trapezio Escaleno: ");
		ladoC = sc.nextDouble();
		System.out.println("Informe a Base Menor do Trapezio Escaleno: ");
		ladoD = sc.nextDouble();
		System.out.println("Informe a altura do Trapezio Escaleno: ");
		altura = sc.nextDouble();

		FiguraGeometrica trapezioEscaleno;
		try {
			trapezioEscaleno = new TrapezioEscaleno(ladoA, ladoB, ladoC, ladoD, altura);
			System.out.println(trapezioEscaleno);

			System.out.println();
			System.out.println(((TrapezioEscaleno) trapezioEscaleno).stringPerimetro());

		} catch (LadoInvalidoException exception) {
			System.out.println(exception.getMessage());

		}

		System.out.println("------------------");
		double lado, base;
		System.out.println("Informe o tamanho do lado do Triângulo: ");
		lado = sc.nextDouble();
		System.out.println("Informe o tamanho da base do Triângulo: ");
		base = sc.nextDouble();
		System.out.println("Informe o tamanho da altura do Triângulo: ");
		altura = sc.nextDouble();

		FiguraGeometrica triangulo;
		try {
			triangulo = new Triangulo(lado, base, altura);
			System.out.println(triangulo);

			System.out.println();
			System.out.println(((Triangulo) triangulo).stringPerimetro());

		} catch (LadoInvalidoException exception) {
			System.out.println(exception.getMessage());

		}

		sc.close();
	}
}