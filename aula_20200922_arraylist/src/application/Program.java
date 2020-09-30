package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.FiguraGeometrica;
import entities.Quadrado;
import entities.Retangulo;
import execptions.LadoInvalidoException;

public class Program {

	public static void main(String[] args) throws LadoInvalidoException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Vamos aprender um pouco de geometria");

		ArrayList<FiguraGeometrica> figuras = new ArrayList<FiguraGeometrica>();
		FiguraGeometrica figura = null;

		// retorna um valor se estiver verdadeiro se houver registro no figuras ou falso
		// se a lista estiver vazia.
		System.out.println(figuras.isEmpty());
		// Quantos elementos tem dentro do elemento? --10 é o tamanho do ArrayList mas a
		// quantidade de elementos dentro do ArrayList se apresenta pelo código abaixo.
		System.out.println(figuras.size());
		System.out.println();

		try {
			figura = new Quadrado(10);
			System.out.println(figura);
			figuras.add(figura);
			figuras.add(figura);
			// retorna um valor se estiver verdadeiro se houver registro no figuras ou falso
			// se a lista estiver vazia.
			System.out.println(figuras.isEmpty());
			// Quantos elementos tem dentro do elemento? --10 é o tamanho do ArrayList mas a
			// quantidade de elementos dentro do ArrayList se apresenta pelo código abaixo.
			System.out.println(figuras.size());

		} catch (LadoInvalidoException exception) {
			System.out.println(exception.getMessage());

		}

		FiguraGeometrica quadrado = null;
		FiguraGeometrica retangulo = null;

		try {

			for (int i = 0; i < 50; i++) {
				
				quadrado = new Quadrado((10 * i) + 1);
				figuras.add(quadrado);
				
				retangulo = new Retangulo((10 * i) + 1, 20 + i);
				figuras.add(retangulo);

			}

			for (int i = 0; i < 100; i++) {
				figura = figuras.get(i);
				System.out.println("A área da figura é: " + figura.calcularArea());
			}

			// retorna um valor se estiver verdadeiro se houver registro no figuras ou falso
			// se a lista estiver vazia.
			System.out.println(figuras.isEmpty());
			// Quantos elementos tem dentro do elemento? --10 é o tamanho do ArrayList mas a
			// quantidade de elementos dentro do ArrayList se apresenta pelo código abaixo.
			System.out.println(figuras.size());

		} catch (LadoInvalidoException exception) {
			System.out.println(exception.getMessage());

		}
		sc.close();
	}
}