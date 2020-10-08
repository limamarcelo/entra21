package application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Pessoa;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
/*		
		//Programa feito com professor
		System.out.println("Vamos cadastrar pessoas:");
		String nome = new String();
		int idade = 0;

		while(!(nome.equals("Allan Renato Sabino"))) {
			System.out.print("Informe o nome da pessoa: ");
			nome = sc.nextLine();
			System.out.print("Informe a idade da pessoa: ");
			idade = sc.nextInt();
			sc.nextLine();
			Pessoa pessoa = new Pessoa(nome, idade);
	
			pessoas.add(pessoa);	
		
			System.out.println();
		}
		
		System.out.println("Relação do cadastro de pessoas:");
		
		for (int i=0;i<pessoas.size();i++) {
			System.out.println("Nome: " + pessoas.get(i).getNome() + ", Idade :"+ pessoas.get(i).getIdade());
		}
*/
		
		//Programa que eu fiz de outra forma.
		
  		System.out.println("Informe quantas pessoas quer cadastrar");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.print("Informe o nome pessoa #" + (i+1) + ": ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Informe a idade da pessoa #" + (i+1) + ": ");
			int idade = sc.nextInt();
			Pessoa pessoa = new Pessoa(nome, idade);
			pessoas.add(pessoa);
		}
		
		System.out.println();
		System.out.println("Relação do cadastro de pessoas:");		
		for (Pessoa x : pessoas) {
			System.out.println("Nome: " + x.getNome() + ", Idade :"+ x.getIdade());
		}	

		sc.close();
	}
}