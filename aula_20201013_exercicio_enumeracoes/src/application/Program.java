package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import comparator.age.AgeAscendingComparator;
import comparator.age.AgeDescendingComparator;
import comparator.name.NameAscendingComparator;
import comparator.name.NameDescendingComparator;
import comparator.password.PasswordAscendingComparator;
import comparator.password.PasswordDescendingComparator;
import comparator.username.UsernameAscendingComparator;
import comparator.username.UsernameDescendingComparator;
import menu.Attribute;
import menu.Menu;
import menu.Order;
import user.user;

public class Program {

	public static void main(String[] args) {

		ArrayList<user> users = new ArrayList<user>();
		Scanner sc = new Scanner(System.in);
		Menu menu;
		do {
			System.out.println("Sejam bem-vindos.\n");

			System.out.println("Selecione uma das seguintes op��es:\n");
			System.out.println("0 - Inserir Usu�rios.");
			System.out.println("1 - Listar Usu�rios.");
			System.out.println("2 - Editar Usu�rios.");
			System.out.println("3 - Excluir Usu�rios.");
			System.out.println("4 - Sair do Sistema.");

			menu = Menu.values()[Integer.parseInt(sc.next())];
			System.out.println();

			switch (menu) {

			case INSERT:
				System.out.println("Informe o nome completo do usu�rio:");
				sc.nextLine();
				String name = sc.nextLine();

				System.out.println("Informe a idade do usu�rio:");
				int age = sc.nextInt();

				System.out.println("Informe nome de usu�rio:");
				String username = sc.next();

				System.out.println("Informe a senha do usu�rio:");
				String password = sc.next();

				System.out.print("\n");

				users.add(new user(name, age, username, password));

				break;
			case LIST:

				System.out.println("Selecione uma das seguintes op��es:\n");
				System.out.println("0 - Listar Usu�rios pelo Nome.");
				System.out.println("1 - Listar Usu�rios pela Idade.");
				System.out.println("2 - Listar Usu�rios pelo Nome de Usu�rio.");
				System.out.println("3 - Listar Usu�rios pela Senha.");

				Attribute attribute = Attribute.values()[Integer.parseInt(sc.next())];

				Comparator<user> comparator = null;
				Order order = null;

				System.out.println("Selecione uma das seguintes op��es:\n");
				System.out.println("0 - Listar em Ordem Ascendente.");
				System.out.println("1 - Listar em Ordem Descendente.");

				order = Order.values()[Integer.parseInt(sc.next())];

				switch (attribute) {

				case NAME:

					switch (order) {

					case ASCENDING:
						comparator = new NameAscendingComparator();
						break;

					case DESCENDING:
						comparator = new NameDescendingComparator();
						break;
					}

					break;

				case AGE:

					switch (order) {

					case ASCENDING:
						comparator = new PasswordAscendingComparator();
						break;

					case DESCENDING:
						comparator = new PasswordDescendingComparator();
						break;
					}

					break;

				case USERNAME:

					switch (order) {

					case ASCENDING:
						comparator = new AgeAscendingComparator();
						break;

					case DESCENDING:
						comparator = new AgeDescendingComparator();
						break;
					}

					break;

				case PASSWORD:

					switch (order) {

					case ASCENDING:
						comparator = new UsernameAscendingComparator();
						break;

					case DESCENDING:
						comparator = new UsernameDescendingComparator();
						break;
					}

					break;
				}

				listUsersOrdered(users, comparator);

				break;
			case EDIT:

				for (int i = 0; i < users.size(); i++) {
					System.out.println(i + " - " + users.get(i).getName());
				}

				System.out.println("Informe o c�digo do usu�rio:");
				int code = sc.nextInt();

				System.out.println("Informe o nome completo do usu�rio:");
				sc.nextLine();
				name = sc.nextLine();

				System.out.println("Informe a idade do usu�rio:");
				age = sc.nextInt();

				System.out.println("Informe nome de usu�rio:");
				username = sc.next();

				System.out.println("Informe a senha do usu�rio:");
				password = sc.next();

				System.out.print("\n");

				users.get(code).setName(name);
				users.get(code).setAge(age);
				users.get(code).setUsername(username);
				users.get(code).setUsername(password);

				break;
			case DELETE:

				for (int i = 0; i < users.size(); i++) {
					System.out.println(i + " - " + users.get(i).getName());
				}

				System.out.println("Informe o c�digo do usu�rio para excluir:");
				code = sc.nextInt();

				users.remove(code);
				break;

			default:
				System.out.println("Por favor tente novamente.");
				break;
			}
		} while (menu != Menu.EXIT);

		sc.close();

		System.out.println("Saindo do Sistema...");
		System.out.println("Muito obrigado e volte sempre.");
	}

	private static void listUsers(ArrayList<user> users) {

		for (int i = 0; i < users.size(); i++) {

			user user = users.get(i);

			System.out.println("Nome: " + user.getName());
			System.out.println("Idade: " + user.getAge());
			System.out.println("Nome de Usu�rio: " + user.getUsername());
			System.out.println("Senha: " + user.getPassword());
			System.out.print("\n");
		}
	}

	private static void listUsersOrdered(ArrayList<user> clientes, Comparator<user> ordem) {
		clientes.sort(ordem);
		listUsers(clientes);
	}
}