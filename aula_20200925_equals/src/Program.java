import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Cidade;
import entities.Estado;
import entities.Pais;
import entities.Pessoa;
import entities.PessoaFisica;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("----------------");
		System.out.println("Pessoas");
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	
		Pessoa pessoa = null;
		
		pessoa = new PessoaFisica("Maria", 1000.00, "015.015.015-015", "Blumenau");
		pessoas.add(pessoa);
		pessoa = new PessoaFisica("João", 1500.00, "016.016.016-16", "Blumenau");
		pessoas.add(pessoa);
		
		System.out.println(pessoas.size());
		System.out.println(pessoas);
		
		pessoa = new PessoaFisica("João", 1500.00, "016.016.016-16", "Blumenau");
		pessoas.remove(pessoa);

		System.out.println(pessoas.size());
		System.out.println(pessoas);

		
		System.out.println("----------------");
		System.out.println("Cidades");
		ArrayList<Cidade> cidades = new ArrayList<>(); 
		
		Cidade cidade = null;
		
		cidade = new Cidade("Rio dos Cedros");
		cidades.add(cidade);
		cidade = new Cidade("Blumenau");
		cidades.add(cidade);
		
		System.out.println(cidades.size());
		System.out.println(cidades);
		
		cidade = new Cidade("Blumenau");
		cidades.remove(cidade);

		System.out.println(cidades.size());
		System.out.println(cidades);
		
		System.out.println("----------------");
		System.out.println("Estado");
		ArrayList<Estado> estados = new ArrayList<>(); 
		
		Estado estado = null;
		
		estado = new Estado("Santa Catarina");
		estados.add(estado);
		estado = new Estado("Mato Grosso do Sul");
		estados.add(estado);
		
		System.out.println(estados.size());
		System.out.println(estados);
		
		estado = new Estado("Santa Catarina");
		estados.remove(estado);

		System.out.println(estados.size());
		System.out.println(estados);
		
		System.out.println("----------------");
		System.out.println("Pais");
		ArrayList<Pais> paises = new ArrayList<>(); 
		
		Pais pais = null;
		
		pais = new Pais("Brasil");
		paises.add(pais);
		pais = new Pais("Canadá");
		paises.add(pais);
		
		System.out.println(paises.size());
		System.out.println(paises);
		
		pais = new Pais("Canadá");
		paises.remove(pais);

		System.out.println(paises.size());
		System.out.println(paises);
		
		sc.close();
	}
}
		