package control.principal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import control.comparator.age.AgeAscendingComparator;
import control.comparator.age.AgeDescendingComparator;
import control.comparator.name.NameAscendingComparator;
import control.comparator.name.NameDescendingComparator;
import control.comparator.password.PasswordAscendingComparator;
import control.comparator.password.PasswordDescendingComparator;
import control.comparator.username.UsernameAscendingComparator;
import control.comparator.username.UsernameDescendingComparator;
import model.dao.user.UserDAO;
import model.dao.user.UserDAOSerializableImpl;
import model.enumeration.menu.Attribute;
import model.enumeration.menu.Menu;
import model.enumeration.menu.Order;
import model.user.User;

public class Program {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ArrayList<User> users = new ArrayList<User>();
		UserDAO dao = new UserDAOSerializableImpl();
		Scanner sc = new Scanner(System.in);

		File db = null;
		Menu menu = null;
		Attribute attribute = null;
		boolean condition;
		String name = null;
		int age = 0;
		String username = null;
		String password = null;

		db = new File("db.txt");

		if (db.length() > 0)
			users = dao.readUsers();

		System.out.println("Seja bem-vindo.\n");
		do {
			do {
				try {
					System.out.println("Selecione uma das seguintes opções:\n");
					System.out.println("1 - Inserir Usuários.");
					System.out.println("2 - Listar Usuários.");
					System.out.println("3 - Editar Usuários.");
					System.out.println("4 - Excluir Usuários.");
					System.out.println("5 - Pesquisar Usuários.");
					System.out.println("6 - Sair do Sistema.");

					menu = Menu.values()[Integer.parseInt(sc.next()) - 1];
					condition = false;

				} catch (NumberFormatException exception) {
					System.err.println("\nFavor informar um número das opções acima");
					condition = true;
				} catch (IndexOutOfBoundsException exception) {
					System.err.println("\nOpção inválida.");
					condition = true;
				} catch (NullPointerException exception) {
					System.err.println("\nDeu erro ao acessar o objeto nulo.");
					condition = true;
				}
			} while (condition == true);

			switch (menu) {

			case INSERT:
				System.out.print("Informe o nome completo do usuário: ");
				sc.nextLine();
				name= sc.nextLine();
				do {
					try {

						System.out.print("Informe a idade do usuário: ");
						age = Integer.parseInt(sc.next());
						condition = false;
						if (age < 0 || age > 120) {
							System.err.println("\nPor favor informe uma idade válida!");
							condition = true;
						}

					} catch (NumberFormatException exception) {
						System.err.println("\nFavor informar uma idade correta");
						condition = true;
					}
				} while (condition == true);

				System.out.print("Informe nome de usuário: ");
				username = sc.next();

				System.out.print("Informe a senha do usuário: ");
				password = sc.next();

				System.out.print("\n");

				users.add(new User(name, age, username, password));

				dao.writeUsers(users);
				
				System.out.println("Usuário Salvo Com Sucesso.\n");

				break;

			case LIST:
				do {
					try {
						System.out.println("Selecione uma das seguintes opções:\n");
						System.out.println("1 - Listar Usuários pelo Nome.");
						System.out.println("2 - Listar Usuários pela Idade.");
						System.out.println("3 - Listar Usuários pelo Nome de Usuário.");
						System.out.println("4 - Listar Usuários pela Senha.");

						attribute = Attribute.values()[Integer.parseInt(sc.next()) - 1];
						condition = false;

					} catch (NumberFormatException exception) {
						System.err.println("\nFavor informar um número das opções acima");
						condition = true;
					} catch (IndexOutOfBoundsException exception) {
						System.err.println("\nOpção inválida.");
						condition = true;
					} catch (NullPointerException exception) {
						System.err.println("\nDeu erro ao acessar o objeto nulo.");
						condition = true;
					}
				} while (condition == true);

				Comparator<User> comparator = null;
				Order order = null;
				do {
					try {
						System.out.println("Selecione uma das seguintes opções:\n");
						System.out.println("1 - Listar em Ordem Ascendente.");
						System.out.println("2 - Listar em Ordem Descendente.");

						order = Order.values()[Integer.parseInt(sc.next()) - 1];
						condition = false;

					} catch (NumberFormatException exception) {
						System.err.println("\nFavor informar um número das opções acima");
						condition = true;
					} catch (IndexOutOfBoundsException exception) {
						System.err.println("\nOpção inválida.");
						condition = true;
					} catch (NullPointerException exception) {
						System.err.println("\nDeu erro ao acessar o objeto nulo.");
						condition = true;
					}
				} while (condition == true);

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
				System.out.println("Os Usuários registrados são: ");

				listUsersOrdered(users, comparator);

				break;

			case EDIT:
				User user = null;
				do {
					try {
						System.out.println("Os Usuários registrados são: ");
						listUsersOrdered(users);

						System.out.println("Informe o código de cadastro do usuário:");
						user = users.get(Integer.parseInt(sc.next()) - 1);
						condition = false;

					} catch (NumberFormatException exception) {
						System.err.println("\nFavor informar um número das opções acima");
						condition = true;
					} catch (IndexOutOfBoundsException exception) {
						System.err.println("\nOpção inválida.");
						condition = true;
					} catch (NullPointerException exception) {
						System.err.println("\nDeu erro ao acessar o objeto nulo.");
						condition = true;
					}
				} while (condition == true);

				do {
					try {
						System.out.print("\n");
						System.out.println("As Opções Disponíveis São:\n");

						System.out.println("1 - Editar O Nome Do Usuário.");
						System.out.println("2 - Editar O Idade Do Usuário.");
						System.out.println("3 - Editar O Nome De Usuário.");
						System.out.println("4 - Editar A Senha Do Usuário.\n");

						System.out.print("Selecione Uma Das Opções Apresentadas: ");

						attribute = Attribute.values()[Integer.parseInt(sc.next()) - 1];
						condition = false;
					} catch (NumberFormatException exception) {
						System.err.println("\nFavor informar um número das opções acima");
						condition = true;
					} catch (IndexOutOfBoundsException exception) {
						System.err.println("\nOpção inválida.");
						condition = true;
					} catch (NullPointerException exception) {
						System.err.println("\nDeu erro ao acessar o objeto nulo.");
						condition = true;
					}
				} while (condition == true);

				switch (attribute) {

				case NAME:

					System.out.print("\n");
					System.out.print("Informe O Novo Nome Do Usuário: ");
					sc.nextLine();
					user.setName(sc.nextLine());

					break;

				case AGE:

					System.out.print("\n");
					System.out.print("Informe A Nova Idade Do Usuário: ");
					user.setAge(Integer.parseInt(sc.next()));

					break;

				case USERNAME:

					System.out.print("\n");
					System.out.print("Informe O Novo Nome De Usuário: ");
					user.setUsername(sc.next());

					break;

				case PASSWORD:

					System.out.print("\n");
					System.out.print("Informe A Nova Senha Do Usuário: ");
					user.setPassword(sc.next());

					break;
				}

				dao.writeUsers(users);
				System.out.println("\nO Usuário Foi Editado Com Sucesso.\n");

				break;
			case DELETE:

				do {
					try {
						System.out.print("\n");
						System.out.println("Os Usuários Cadastrados São:\n");

						listUsersOrdered(users);

						System.out.print("Informe o código do usuário para excluir: ");
						users.remove(Integer.parseInt(sc.next()) - 1);
						condition = false;

					} catch (IndexOutOfBoundsException exception) {
						System.err.println("\nOpção Inválida");
						condition = true;
					} catch (NumberFormatException exception) {
						System.err.println("\nFavor informar um número das opções acima");
						condition = true;
					} catch (NullPointerException exception) {
						System.err.println("\nDeu erro ao acessar o objeto nulo.");
						condition = true;
					}
				} while (condition == true);

				dao.writeUsers(users);
				System.out.println("O Usuário Foi Deletado Com Sucesso.\n");

				break;

			case SEARCH:

				System.out.print("Informe O Nome do Usuário Que Você Deseja Pesquisar: ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.println();

				listUsers(foundUserName(name, users));

				break;

			default:
				break;
			}

		} while (menu != Menu.EXIT);
		System.out.println("Saindo do Sistema...");
		System.out.println("Muito obrigado e volte sempre.");

		sc.close();
	}

	private static void listUsers(List<User> users) {

		if (users.size() > 0) {
			for (int i = 0; i < users.size(); i++) {

				User user = users.get(i);

				System.out.println("Nome: " + user.getName());
				System.out.println("Idade: " + user.getAge());
				System.out.println("Nome de Usuário: " + user.getUsername());
				System.out.println("Senha: " + user.getPassword());
				System.out.print("\n");
			}
		} else {
			System.out.println("Usuário não encontrado\n");
		}
	}

	private static void listUsersOrdered(List<User> users) {

		for (int i = 0; i < users.size(); i++) {

			User user = users.get(i);

			System.out.println("Cadastro #" + (i + 1));
			System.out.println("Nome: " + user.getName());
			System.out.println("Idade: " + user.getAge());
			System.out.println("Nome de Usuário: " + user.getUsername());
			System.out.println("Senha: " + user.getPassword());
			System.out.print("\n");
		}
	}

	private static ArrayList<User> foundUserName(String name, List<User> users) {

		ArrayList<User> usersFound = new ArrayList<User>();
		User user = null;

		for (int i = 0; i < users.size(); i++) {

			user = users.get(i);

			if (user.getName().equalsIgnoreCase(name))
				usersFound.add(user);
		}
		if (usersFound.size() > 0) {
			System.out.println("\nOs Usuários Cadastrados Com O Nome " + name + " São:\n");
		}
		return usersFound;
	}

	private static void listUsersOrdered(ArrayList<User> users, Comparator<User> ordered) {
		users.sort(ordered);
		listUsers(users);
	}
}