package application;

import java.util.ArrayList;
import java.util.Collections;

import entities.Pessoa;

public class Program {

	public static void main(String[] args) {

		int a = 10;
		int b = 10;
		System.out.println(a == b);

		String a1 = "10";
		String b1 = "10";
		String c1 = "10";
		System.out.println(a1 == b1);
		System.out.println(a1 == c1);

		// Comparando objetos
		Pessoa pessoa1 = new Pessoa("Allan", 30);
		Pessoa pessoa2 = new Pessoa("Allan", 30);
		System.out.println(pessoa1 == pessoa2);

		// Falso pois procura endereço de memória
		pessoa1 = new Pessoa("Allan", 30);
		pessoa2 = new Pessoa("Allan", 30);
		System.out.println(pessoa1.equals(pessoa2));

		// equals também pesquisa local de memória, então temos que sobreescrever.
		// Por colocar o código abaixo na Classe Pessoa foi possível conseguir o
		// resultado de True;

		/*
		 * public boolean equals(Object objeto) {
		 * 
		 * if (this == objeto) return true;
		 * 
		 * if (objeto == null) return false;
		 * 
		 * // this.getClass() ou getClass tanto faz. if (getClass() !=
		 * objeto.getClass()) return false;
		 * 
		 * Pessoa pessoa = (Pessoa) objeto; // abaixo não dá para comparar com != o cpf
		 * pois o pessoa.getCpf() é do tipo // PessoaFisica e o outro uma String não do
		 * tipo primitivo então tem que // comparar utilizando o equals if
		 * (!(getNome().equals(pessoa.getNome()) ||
		 * !(getIdade().equals(pessoa.getIdade())))) return false;
		 * 
		 * return true; }
		 */

		// Ordenando uma lista utilizando Collections e Inetrface na Classe Pessoa =
		// implements Comparable<Pessoa>

		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoa1 = new Pessoa("Sidynéia", 36);
		pessoas.add(pessoa1);
		pessoa2 = new Pessoa("Marcelo", 35);
		pessoas.add(pessoa2);
		Pessoa pessoa3 = new Pessoa("André", 34);
		pessoas.add(pessoa3);
		//adicionado cadastro de pessoas acima e ordenado abaixo pelo Collections.sort(pessoas) cfe. abaixo
		Collections.sort(pessoas);
		//pela idade conforme

		//Na classe pessoas adicionado cfe. abaixo o compareTo e implements Comparable<Pessoa>
		/*@Override
		public int compareTo(Pessoa pessoa) {
			
			if (this.getIdade() <pessoa.getIdade())
			return -1;
			
			if(this.getIdade()>pessoa.getIdade())
				return 1;		
			return 0;
		}
		*/
		
		for (int i = 0; i < pessoas.size(); i++) {
			System.out.println("Nome: " + pessoas.get(i).getNome() + ", idade: " + pessoas.get(i).getIdade());
		}

	}
}