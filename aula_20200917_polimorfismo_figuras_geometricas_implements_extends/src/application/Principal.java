package application;

import java.util.Locale;
import java.util.Scanner;

import entities.FiguraGeometrica;
import entities.Paralelograma;
import entities.Quadrado;
import entities.Quadrilatero;
import entities.Retangulo;
import entities.TrapezioEscaleno;
import entities.TrapezioIsosceles;

public class Principal {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o lado A do Quadrado: ");
		double ladoA = sc.nextDouble();

		FiguraGeometrica quadrado = new Quadrado(ladoA);
				
		System.out.println(quadrado);
		//substituido pelo toString padr�o
		//System.out.println("O quadrado com lado A: " + ((Quadrilatero) quadrado).getLadoA() + ", tem a �rea de: " + areaQuadrado);
		
		System.out.println();
				
		System.out.println(((Quadrado) quadrado).stringPerimetroQuadrado());

		//substituido pelo toString espec�fico do stringPerimetroQuadrado
		//System.out.println("O quadrado com lado A: " + ((Quadrilatero) quadrado).getLadoA() + ", tem o per�metro de: " + perimetroQuadrado);

		System.out.println("------------------");

		System.out.println("Informe o lado A do Ret�ngulo: ");
		ladoA = sc.nextDouble();
		System.out.println("Informe o lado B do Ret�ngulo: ");
		double ladoB = sc.nextDouble();
		FiguraGeometrica retangulo = new Retangulo(ladoA, ladoB);

		double areaRetangulo = retangulo.calcularArea();
		System.out.println("O ret�ngulo com lado A: " + ((Quadrilatero) retangulo).getLadoA() + " e com lado B: "
				+ ((Quadrilatero) retangulo).getLadoB() + ", tem a �rea de: " + areaRetangulo);
		System.out.println();
		double perimetroRetangulo = retangulo.calcularPerimetro();
		System.out.println("O ret�ngulo com lado A: " + ((Quadrilatero) retangulo).getLadoA() + " e com lado B: "
				+ ((Quadrilatero) retangulo).getLadoB() + ", tem o per�metro de: " + perimetroRetangulo);

		System.out.println("------------------");

		System.out.println("Informe o lado A do Paralelograma: ");
		ladoA = sc.nextDouble();
		System.out.println("Informe o lado B do Paralelograma: ");
		ladoB = sc.nextDouble();
		FiguraGeometrica paralelograma = new Paralelograma(ladoA, ladoB);

		double areaParalelograma = paralelograma.calcularArea();
		System.out
				.println("O Paralelograma com lado A: " + ((Quadrilatero) paralelograma).getLadoA() + " e com lado B: "
						+ ((Quadrilatero) paralelograma).getLadoB() + ", tem a �rea de: " + areaParalelograma);
		System.out.println();
		double perimetroParalelograma = paralelograma.calcularPerimetro();
		System.out.println("O Paralelograma com lado A: " + ((Quadrilatero) paralelograma).getLadoA()
				+ " e com lado B: " + ((Quadrilatero) paralelograma).getLadoB() + ", tem o per�metro de: "
				+ perimetroParalelograma);

		System.out.println("------------------");

		System.out.println("Informe o tamanho dos lados do Trapezio Is�sceles: ");
		ladoA = sc.nextDouble();
		System.out.println("Informe a Base Maior do Trapezio Is�sceles: ");
		ladoB = sc.nextDouble();
		System.out.println("Informe a Base Menor do Trapezio Is�sceles: ");
		double ladoD = sc.nextDouble();
		System.out.println("Informe a altura do Trapezio Is�sceles: ");
		double altura = sc.nextDouble();

		FiguraGeometrica trapezioIsosceles = new TrapezioIsosceles(ladoA, ladoB, ladoA, ladoD, altura);

		double areaTrapezioIsosceles = trapezioIsosceles.calcularArea();
		System.out.println("O Trap�zio com lado A: " + ((Quadrilatero) trapezioIsosceles).getLadoA()
				+ " e com a Base Maior: " + ((Quadrilatero) trapezioIsosceles).getLadoB() + " e com lado C: "
				+ ((Quadrilatero) trapezioIsosceles).getLadoC() + " e com a Base Menor: "
				+ ((Quadrilatero) trapezioIsosceles).getLadoD() + " e com altura de: "
				+ ((TrapezioIsosceles) trapezioIsosceles).getAltura() + ", tem a �rea de: " + areaTrapezioIsosceles);
		System.out.println();
		double perimetroTrapezioIsosceles = trapezioIsosceles.calcularPerimetro();
		System.out.println("O Trap�zio com lado A: " + ((Quadrilatero) trapezioIsosceles).getLadoA()
				+ " e com a Base Maior: " + ((Quadrilatero) trapezioIsosceles).getLadoB() + " e com lado C: "
				+ ((Quadrilatero) trapezioIsosceles).getLadoC() + " e com a Base Menor: "
				+ ((Quadrilatero) trapezioIsosceles).getLadoD() + ", tem o per�metro de: "
				+ perimetroTrapezioIsosceles);

		System.out.println("------------------");

		System.out.println("Informe o lado A do Trapezio: ");
		ladoA = sc.nextDouble();
		System.out.println("Informe a Base Maior do Trapezio: ");
		ladoB = sc.nextDouble();
		System.out.println("Informe o lado C do Trapezio: ");
		double ladoC = sc.nextDouble();
		System.out.println("Informe a Base Menor do Trapezio: ");
		ladoD = sc.nextDouble();
		System.out.println("Informe a altura do Trapezio: ");
		altura = sc.nextDouble();

		FiguraGeometrica trapezioEscaleno = new TrapezioEscaleno(ladoA, ladoB, ladoC, ladoD, altura);

		double areaTrapezioEscaleno = trapezioEscaleno.calcularArea();
		System.out.println("O Trap�zio com lado A: " + ((Quadrilatero) trapezioEscaleno).getLadoA()
				+ " e com a Base Maior: " + ((Quadrilatero) trapezioEscaleno).getLadoB() + " e com lado C: "
				+ ((Quadrilatero) trapezioEscaleno).getLadoC() + " e com a Base Menor: "
				+ ((Quadrilatero) trapezioEscaleno).getLadoD() + " e com altura de: "
				+ ((TrapezioEscaleno) trapezioEscaleno).getAltura() + ", tem a �rea de: " + areaTrapezioEscaleno);
		System.out.println();
		double perimetroTrapezioEscaleno = trapezioEscaleno.calcularPerimetro();
		System.out.println("O Trap�zio com lado A: " + ((Quadrilatero) trapezioEscaleno).getLadoA()
				+ " e com a Base Maior: " + ((Quadrilatero) trapezioEscaleno).getLadoB() + " e com lado C: "
				+ ((Quadrilatero) trapezioEscaleno).getLadoC() + " e com a Base Menor: "
				+ ((Quadrilatero) trapezioEscaleno).getLadoD() + ", tem o per�metro de: " + perimetroTrapezioEscaleno);

		sc.close();
	}
}