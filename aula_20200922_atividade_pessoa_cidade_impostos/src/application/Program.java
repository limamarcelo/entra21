package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Cidade;
import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Cidade cidade = new Cidade("Blumenau");
		// Pessoa pessoa = new PessoaFisica();
		Pessoa pessoa = null;

		pessoa = new PessoaFisica("João", 1000.00);
		// abaixo para usar caso adicionarHabitante seja void.
		// cidade.adicionarHabitante(pessoa);

		//abaixo adicionando habitante com o método boolean
		if (cidade.adicionarHabitante(pessoa)) {
			System.out.println("Pessoa adicionada com sucesso.");
		}

		pessoa = new PessoaFisica("Maria", 1200.00);
		if (cidade.adicionarHabitante(pessoa)) {
			System.out.println("Pessoa adicionada com sucesso.");
		}

		pessoa = new PessoaJuridica("SENAI", 10000.00);
		if (cidade.adicionarHabitante(pessoa)) {
			System.out.println("Pessoa adicionada com sucesso.");
		}

		System.out.println("A arrecadação da cidade foi de: " + cidade.calcularArrecadacao());

		sc.close();
	}
}