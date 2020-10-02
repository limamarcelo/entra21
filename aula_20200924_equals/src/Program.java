

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Pessoa habitantes;

		Pessoa pessoa1 = null;
		Pessoa pessoa2 = null;
		Object pessoas = null;
		
		pessoa1 = new PessoaFisica("Maria", 1000.00);

		pessoa2 = new PessoaFisica("João", 1500.00);
		
		pessoas = pessoa1;
		
		System.out.println(pessoas.equals(pessoa1));
	
		String nome;
		double provento;
		
		habitantes = new Pessoa(nome, provento);
		
		for(int i=0;i<habitantes.)
		System.out.println(pessoas.toString());

		
		sc.close();
	}
}