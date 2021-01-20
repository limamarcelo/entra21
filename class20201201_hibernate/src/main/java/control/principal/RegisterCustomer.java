package control.principal;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import execptions.CustomerAgeException;
import execptions.CustomerCpfException;
import execptions.CustomerDebtException;
import execptions.CustomerNameException;
import model.customer.Customer;
import model.dao.customer.CustomerDAO;
import model.dao.customer.CustomerDAOSGBDImpl;
import model.enumeration.menu.AttributeCustomer;
import model.enumeration.menu.Menu;
import model.enumeration.menu.Order;
import model.enumeration.menu.SubMenu;
import model.enumeration.menu.SubMenuEditCustomer;

public class RegisterCustomer {

	public static void main(String[] args) throws CustomerNameException, CustomerCpfException, CustomerAgeException, NumberFormatException, CustomerDebtException {

		Scanner sc = new Scanner(System.in);
		Menu menu = null;
		SubMenu subMenu = null;
		SubMenuEditCustomer subMenuEditCustomer = null;
		CustomerDAO daoCustomer = new CustomerDAOSGBDImpl();
		List<Customer> customers = null;
		Customer customer = null;
		boolean condition;

		// inicia Menu Principal - escolher Cliente, Produto ou Pedido
		System.out.println("Seja bem-vindo.\n");
		do {
			do {
				try {
					System.out.println("Selecione uma das seguintes opções:\n");
					System.out.println("1 - Cliente");
					System.out.println("2 - Sair");

					menu = Menu.values()[Integer.parseInt(sc.next()) - 1];
					condition = false;
					System.out.println();
				} catch (NumberFormatException exception) {
					System.err.println("\nFavor informar um número das opções acima.\n");
					condition = true;
				} catch (IndexOutOfBoundsException exception) {
					System.err.println("\nOpção inválida.\n");
					condition = true;
				} catch (NullPointerException exception) {
					System.err.println("\nErro ao acessar o objeto nulo.\n");
					condition = true;
				}
			} while (condition);

			switch (menu) {

			// Inicia subMenu escolha Cliente
			case CUSTOMER:

				// inicia subMenu - escolher ação CRUD Clientes - Inserir, Listar,
				// Editar, Excluir e Voltar Menu Principal.
				int idCustomer = 0;
				do {
					do {
						try {
							System.out.println("Selecione uma das seguintes opções:\n");
							System.out.println("1 - Inserir Cliente.");
							System.out.println("2 - Listar Clientes.");
							System.out.println("3 - Editar Cliente.");
							System.out.println("4 - Excluir Cliente.");
							System.out.println("5 - Voltar Menu Principal.");

							subMenu = SubMenu.values()[Integer.parseInt(sc.next()) - 1];
							condition = false;
							System.out.println();
						} catch (NumberFormatException exception) {
							System.err.println("\nFavor informar um número das opções acima.\n");
							condition = true;
						} catch (IndexOutOfBoundsException exception) {
							System.err.println("\nOpção inválida.\n");
							condition = true;
						} catch (NullPointerException exception) {
							System.err.println("\nErro ao acessar o objeto nulo.\n");
							condition = true;
						}
					} while (condition);

					switch (subMenu) {

					case INSERT:

						System.out.println("Informe o nome do cliente:");
						sc.nextLine();
						String name = sc.nextLine();

						System.out.println("Informe o CPF do cliente:");
						String cpf = sc.nextLine();

						System.out.println("Informe a idade do cliente:");
						int age = Integer.parseInt(sc.next());

						System.out.println("Informe a dívida do cliente:");
						double debt = Double.parseDouble(sc.next());
						
						try {
							daoCustomer.insertCustomer(new Customer(name, cpf, age, debt));
						} catch (CustomerCpfException exception) {
							System.err.println(exception.getMessage());
						}
						catch (CustomerAgeException exception) {
							System.err.println(exception.getMessage());
						}
						catch (CustomerNameException exception) {
							System.err.println(exception.getMessage());
						}
						catch (CustomerDebtException exception) {
							System.err.println(exception.getMessage());
						}

						System.out.println("Cliente Salvo Com Sucesso.\n");

						break;

					case LIST:

						AttributeCustomer attribute = null;
						Comparator<Customer> comparator = null;
						Order order = null;
						do {
							try {
								System.out.println("Selecione uma das seguintes opções:\n");
								System.out.println("1 - Listar Clientes pelo Id.");
								System.out.println("2 - Listar Clientes pelo Nome.");
								System.out.println("3 - Listar Clientes pelo CPF.");
								System.out.println("4 - Listar Clientes pela Idade.");
								System.out.println("5 - Listar Clientes pela Dívida.\n");

								attribute = AttributeCustomer.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um número das opções acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOpção inválida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);
						do {
							try {
								System.out.println("Selecione uma das seguintes opções:\n");
								System.out.println("1 - Listar em Ordem Ascendente.");
								System.out.println("2 - Listar em Ordem Descendente.");

								order = Order.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();
							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um número das opções acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOpção inválida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						switch (attribute) {

						case ID:

							switch (order) {

							case ASCENDING:
								customers = daoCustomer.listCustomers();
								// customers = daoCustomer.listCustomersOrderByIdAsc();
								break;

							case DESCENDING:
								customers = daoCustomer.listCustomersOrderByIdDesc();
								break;
							}

							break;

						case NAME:

							switch (order) {

							case ASCENDING:
								customers = daoCustomer.listCustomersOrderByNameAsc();
								break;

							case DESCENDING:
								customers = daoCustomer.listCustomersOrderByNameDesc();
								break;
							}

							break;

						case CPF:

							switch (order) {

							case ASCENDING:
								customers = daoCustomer.listCustomersOrderByCpfAsc();
								break;

							case DESCENDING:
								customers = daoCustomer.listCustomersOrderByCpfDesc();
								break;
							}

							break;

						case AGE:

							switch (order) {

							case ASCENDING:
								customers = daoCustomer.listCustomersOrderByAgeAsc();
								break;

							case DESCENDING:
								customers = daoCustomer.listCustomersOrderByAgeDesc();
								break;
							}

							break;

						case DEBT:

							switch (order) {

							case ASCENDING:
								customers = daoCustomer.listCustomersOrderByDebtAsc();
								break;

							case DESCENDING:
								customers = daoCustomer.listCustomersOrderByDebtDesc();
								break;
							}

							break;
						}

						System.out.println("\n");
						System.out.println("Os Clientes Cadastrados São:\n");

						listCustomers(customers);

						break;

					case EDIT:
						// inicia subMenuEditCustomer para edição de Cliente;
						do {
							do {
								try {

									System.out.print("\n");
									System.out.println("Os Clientes Cadastrados São:\n");

									customers = daoCustomer.listCustomers();
									listNumberedCustomers(customers);

									System.out.print("Selecione Um Dos Clientes Para Editar: ");
									customer = customers.get(Integer.parseInt(sc.next()) - 1);

									System.out.println("Selecione uma das seguintes opções:\n");
									System.out.println("1 - Alterar o nome do cliente.");
									System.out.println("2 - Alterar o cpf do cliente.");
									System.out.println("3 - Alterar o idade do cliente.");
									System.out.println("4 - Alterar a dívida do cliente.");
									System.out.println("5 - Alterar todos os dados do cliente.");
									System.out.println("6 - Voltar Menu Principal.");

									subMenuEditCustomer = SubMenuEditCustomer.values()[Integer.parseInt(sc.next()) - 1];
									condition = false;
									System.out.println();
								} catch (NumberFormatException exception) {
									System.err.println("\nFavor informar um número das opções acima.\n");
									condition = true;
								} catch (IndexOutOfBoundsException exception) {
									System.err.println("\nOpção inválida.\n");
									condition = true;
								} catch (NullPointerException exception) {
									System.err.println("\nErro ao acessar o objeto nulo.\n");
									condition = true;
								}
							} while (condition);

							switch (subMenuEditCustomer) {

							case NAME:
								System.out.print("\nInforme O Novo Nome Do Cliente: ");
								sc.nextLine();
								customer.setName(sc.nextLine());
								daoCustomer.updateCustomer(customer);

								break;

							case CPF:
								System.out.print("\nInforme O Novo CPF Do Cliente: ");

								customer.setCpf(sc.next());
								daoCustomer.updateCustomer(customer);

								break;

							case AGE:
								System.out.print("\nInforme A Nova Idade Do Cliente: ");

								customer.setAge(Integer.parseInt(sc.next()));
								daoCustomer.updateCustomer(customer);

								break;

							case DEBT:
								System.out.print("\nInforme A Nova Dívida Do Cliente: ");

								customer.setDebt(Double.parseDouble(sc.next()));
								daoCustomer.updateCustomer(customer);

								break;
							}

							System.out.println("\nO Cliente Foi Editado Com Sucesso.\n");

						} while (subMenuEditCustomer != SubMenuEditCustomer.EXIT);
						// final subMenuEditCustomer para edição de Cliente
						break;

					case DELETE:
						do {
							try {

								System.out.print("\n");
								System.out.println("Os Clientes Cadastrados São:\n");

								customers = daoCustomer.listCustomers();
								listNumberedCustomers(customers);

								System.out.print("Selecione Um Dos Clientes Para Excluir: ");
								customer = customers.get(Integer.parseInt(sc.next()) - 1);

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um número das opções acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOpção inválida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						daoCustomer.removeCustomer(customer);
						System.out.println("O Cliente Foi Deletado Com Sucesso.\n");

						break;
					}
				} while (subMenu != SubMenu.EXIT);
				// final do subMenu para Cliente
				break;
			}

		} while (menu != Menu.EXIT);
		// final do Menu Geral.

		System.out.println("Saindo do Sistema...");
		System.out.println("Muito obrigado e volte sempre.");

		sc.close();

	}

	private static void listCustomers(List<Customer> customers) {

		for (int i = 0; i < customers.size(); i++) {

			Customer customer = customers.get(i);

			System.out.println("Nome: " + customer.getName());
			System.out.println("CPF: " + customer.getCpf());
			System.out.println("Idade: " + customer.getAge());
			System.out.println("Dívida: " + customer.getDebt());
			System.out.print("\n");
		}
	}

	private static void listNumberedCustomers(List<Customer> customers) {

		for (int i = 0; i < customers.size(); i++) {

			Customer customer = customers.get(i);

			System.out.println("Cliente De Número " + (i + 1));

			System.out.println("Nome: " + customer.getName());
			System.out.println("CPF: " + customer.getCpf());
			System.out.println("Idade: " + customer.getAge());
			System.out.println("Dívida: " + customer.getDebt());
			System.out.print("\n");
		}
	}
}