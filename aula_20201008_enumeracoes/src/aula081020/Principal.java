package aula081020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import aula081020.cliente.Cliente;
import aula081020.comparador.cpf.CpfAscendenteComparator;
import aula081020.comparador.cpf.CpfDescendenteComparator;
import aula081020.comparador.divida.DividaAscendenteComparator;
import aula081020.comparador.divida.DividaDescendenteComparator;
import aula081020.comparador.idade.IdadeAscendenteComparator;
import aula081020.comparador.idade.IdadeDescendenteComparator;
import aula081020.comparador.nome.NomeAscendenteComparator;
import aula081020.comparador.nome.NomeDescententeComparator;
import aula081020.menu.Atributo;
import aula081020.menu.Menu;
import aula081020.menu.Ordem;

public class Principal {

	public static void main(String[] args) {

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Scanner leitor = new Scanner(System.in);

		System.out.println("Sejam bem-vindos.\n");

		System.out.println("Selecione uma das seguintes opções:\n");
		System.out.println("0 - Inserir Clientes.");
		System.out.println("1 - Listar Clientes.");
		System.out.println("2 - Sair do Sistema.");

		Menu menu = Menu.values()[Integer.parseInt(leitor.next())];

		while (menu != Menu.SAIR) {

			switch (menu) {

			case INSERIR:

				System.out.println("Informe o nome do cliente:");
				String nome = leitor.next();

				System.out.println("Informe o CPF do cliente:");
				String cpf = leitor.next();

				System.out.println("Informe a idade do cliente:");
				int idade = Integer.parseInt(leitor.next());

				System.out.println("Informe a dívida do cliente:");
				double divida = Double.parseDouble(leitor.next());
				
				System.out.print("\n");

				clientes.add(new Cliente(nome, cpf, idade, divida));

				break;

			case LISTAR:

				System.out.println("Selecione uma das seguintes opções:\n");
				System.out.println("0 - Listar Clientes pelo Nome.");
				System.out.println("1 - Listar Clientes pelo CPF.");
				System.out.println("2 - Listar Clientes pela Idade.");
				System.out.println("3 - Listar Clientes pela Dívida.");

				Atributo atributo = Atributo.values()[Integer.parseInt(leitor.next())];

				Comparator<Cliente> comparador = null;
				Ordem ordem = null;
				
				System.out.println("Selecione uma das seguintes opções:\n");
				System.out.println("0 - Listar em Ordem Ascendente.");
				System.out.println("1 - Listar em Ordem Descendente.");

				ordem = Ordem.values()[Integer.parseInt(leitor.next())];

				switch (atributo) {

				case NOME:

					switch (ordem) {

					case ASCENDENTE:
						comparador = new NomeAscendenteComparator();
						break;

					case DESCENDENTE:
						comparador = new NomeDescententeComparator();
						break;
					}

					break;

				case CPF:
					
					switch (ordem) {

					case ASCENDENTE:
						comparador = new CpfAscendenteComparator();
						break;

					case DESCENDENTE:
						comparador = new CpfDescendenteComparator();
						break;
					}
					
					break;

				case IDADE:
					
					switch (ordem) {

					case ASCENDENTE:
						comparador = new IdadeAscendenteComparator();
						break;

					case DESCENDENTE:
						comparador = new IdadeDescendenteComparator();
						break;
					}
					
					break;

				case DIVIDA:
					
					switch (ordem) {

					case ASCENDENTE:
						comparador = new DividaAscendenteComparator();
						break;

					case DESCENDENTE:
						comparador = new DividaDescendenteComparator();
						break;
					}
				
					break;
				}

				listarClientesOrdenados(clientes, comparador);

				break;

			}

			System.out.println("Selecione uma das seguintes opções:\n");
			System.out.println("0 - Inserir Clientes.");
			System.out.println("1 - Listar Clientes.");
			System.out.println("2 - Sair do Sistema.");

			menu = Menu.values()[Integer.parseInt(leitor.next())];
		}

		leitor.close();

		System.out.println("Saindo do Sistema...");
		System.out.println("Muito obrigado e volte sempre.");

	}

	private static void listarClientes(ArrayList<Cliente> clientes) {

		for (int i = 0; i < clientes.size(); i++) {

			Cliente cliente = clientes.get(i);

			System.out.println("Nome: " + cliente.getNome());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("Idade: " + cliente.getIdade());
			System.out.println("Dívida: " + cliente.getDivida());
			System.out.print("\n");
		}
	}

	private static void listarClientesOrdenados(ArrayList<Cliente> clientes, Comparator<Cliente> ordem) {
		clientes.sort(ordem);
		listarClientes(clientes);
	}
}