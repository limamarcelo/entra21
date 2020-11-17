import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Cidade;
import entities.Pessoa;
import entities.PessoaFisica;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		ArrayList<Pessoa> habitantes = new ArrayList<>();

		Pessoa pessoa1 = null;
		Pessoa pessoa2 = null;
		Pessoa pessoa3 = null;
		Object pessoas = null;

		pessoa1 = new PessoaFisica("Maria", 1000.00);

		pessoa2 = new PessoaFisica("João", 1500.00);

		pessoa3 = new PessoaFisica("Maria", 1000.00);

		pessoas = pessoa1;

		// pessoa1 = (Pessoa) pessoas;

		System.out.println(pessoas.equals(pessoa1));
		// System.out.println(pessoa1.equals(pessoas));
		System.out.println(pessoa3.equals(pessoa1));

		sc.close();
	}
}