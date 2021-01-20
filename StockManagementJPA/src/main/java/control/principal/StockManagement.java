package control.principal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;

import model.comparator.address.id.IdAscendingComparatorAddress;
import model.comparator.address.id.IdDescendingComparatorAddress;
import model.comparator.address.publicplace.NameAscendingComparatorAddress;
import model.comparator.address.publicplace.NameDescendingComparatorAddress;
import model.comparator.customer.id.IdAscendingComparatorCustomer;
import model.comparator.customer.id.IdDescendingComparatorCustomer;
import model.comparator.customer.name.NameAscendingComparatorCustomer;
import model.comparator.customer.name.NameDescendingComparatorCustomer;
import model.comparator.customer.surname.SurnameAscendingComparatorCustomer;
import model.comparator.customer.surname.SurnameDescendingComparatorCustomer;
import model.comparator.product.code.CodeAscendingComparatorProduct;
import model.comparator.product.code.CodeDescendingComparatorProduct;
import model.comparator.product.id.IdAscendingComparatorProduct;
import model.comparator.product.id.IdDescendingComparatorProduct;
import model.comparator.product.name.NameAscendingComparatorProduct;
import model.comparator.product.name.NameDescendingComparatorProduct;
import model.dao.customer.CustomerDAO;
import model.dao.customer.CustomerDAOSGBDImpl;
import model.dao.customer.address.AddressDAO;
import model.dao.customer.address.AddressDAOSGBDImpl;
import model.dao.product.ProductDAO;
import model.dao.product.ProductDAOSGBDImpl;
import model.entity.customer.Customer;
import model.entity.customer.address.Address;
import model.entity.product.Product;
import model.enumeration.attributes.AttributeAddress;
import model.enumeration.attributes.AttributeCustomer;
import model.enumeration.attributes.AttributeProduct;
import model.enumeration.menu.Menu;
import model.enumeration.menu.ordination.Order;
import model.enumeration.menu.submenu.SubMenu;
import model.enumeration.menu.submenu.SubMenuEditAddress;
import model.enumeration.menu.submenu.SubMenuEditCustomer;
import model.enumeration.menu.submenu.SubMenuEditProduct;
import model.enumeration.menu.submenu.SubMenuLinkAddress;
import model.execptions.CustomerNameException;
import model.execptions.CustomerPhoneNumberException;
import model.execptions.CustomerPublicPlaceException;
import model.execptions.CustomerSurnameException;
import model.execptions.ProductCodeException;
import model.execptions.ProductNameException;

public class StockManagement {

	public static void main(String[] args)
			throws HibernateException, SQLException, CustomerSurnameException, CustomerNameException,
			CustomerPhoneNumberException, ProductNameException, ProductCodeException, CustomerPublicPlaceException {

		Scanner sc = new Scanner(System.in);
		Menu menu = null;
		SubMenu subMenu = null;
		SubMenuEditCustomer subMenuEditCustomer = null;
		SubMenuEditAddress subMenuEditAddress = null;
		SubMenuLinkAddress subMenuLinkAddress = null;
		// SubMenuEditCustomerOrder subMenuEditCustomerOrder = null;
		SubMenuEditProduct subMenuEditProduct = null;
		List<Customer> customers = null;
		List<Product> products = null;
		List<Address> addresses = null;
		CustomerDAO daoCustomer = new CustomerDAOSGBDImpl();
		AddressDAO daoAddress = new AddressDAOSGBDImpl();
		ProductDAO daoProduct = new ProductDAOSGBDImpl();
		// CustomerOrderDAO daoCustomerOrder = new CustomerOrderDAOSGBDImpl();
		boolean condition;

		// inicia Menu Principal - escolher Cliente, Endere�o, Produto ou Pedido
		System.out.println("Seja bem-vindo.\n");
		do {
			do {
				try {
					System.out.println("Selecione uma das seguintes op��es:\n");
					System.out.println("1 - Cliente");
					System.out.println("2 - Endere�o");
					System.out.println("3 - Vincular/Desvincular de Cliente/Endere�o");
					System.out.println("4 - Produto");
					System.out.println("5 - Pedido");
					System.out.println("6 - Sair");

					menu = Menu.values()[Integer.parseInt(sc.next()) - 1];
					condition = false;
					System.out.println();
				} catch (NumberFormatException exception) {
					System.err.println("\nFavor informar um n�mero das op��es acima.\n");
					condition = true;
				} catch (IndexOutOfBoundsException exception) {
					System.err.println("\nOp��o inv�lida.\n");
					condition = true;
				} catch (NullPointerException exception) {
					System.err.println("\nErro ao acessar o objeto nulo.\n");
					condition = true;
				}
			} while (condition);

			switch (menu) {

			// Inicia subMenu escolha Cliente
			case CUSTOMER:
				customers = new ArrayList<Customer>();
				Customer customer = new Customer();
				// inicia subMenu - escolher a��o CRUD Clientes - Inserir, Listar,
				// Editar, Excluir e Voltar Menu Principal.
				do {
					do {
						try {
							System.out.println("Selecione uma das seguintes op��es:\n");
							System.out.println("1 - Inserir Cliente.");
							System.out.println("2 - Listar Clientes.");
							System.out.println("3 - Editar Cliente.");
							System.out.println("4 - Excluir Cliente.");
							System.out.println("5 - Voltar Menu Principal.");

							subMenu = SubMenu.values()[Integer.parseInt(sc.next()) - 1];
							condition = false;
							System.out.println();

						} catch (NumberFormatException exception) {
							System.err.println("\nFavor informar um n�mero das op��es acima.\n");
							condition = true;
						} catch (IndexOutOfBoundsException exception) {
							System.err.println("\nOp��o inv�lida.\n");
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

						System.out.println("Informe o sobrenome do cliente:");
						String surname = sc.nextLine();

						customer.setName(name);
						customer.setSurname(surname);

						daoCustomer.insertCustomer(customer);

						System.out.print("\n");

						break;

					case LIST:
						AttributeCustomer attribute = null;
						Comparator<Customer> comparator = null;
						Order order = null;
						do {
							try {
								System.out.println("Selecione uma das seguintes op��es:\n");
								System.out.println("1 - Listar Clientes pelo Id.");
								System.out.println("2 - Listar Clientes pelo Nome.");
								System.out.println("3 - Listar Clientes pelo Sobrenome.");
								System.out.println("4 - Voltar Menu Principal.");

								attribute = AttributeCustomer.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um n�mero das op��es acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOp��o inv�lida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);
						do {
							try {
								System.out.println("Selecione uma das seguintes op��es:\n");
								System.out.println("1 - Listar em Ordem Ascendente.");
								System.out.println("2 - Listar em Ordem Descendente.");

								order = Order.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um n�mero das op��es acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOp��o inv�lida.\n");
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
								comparator = new IdAscendingComparatorCustomer();
								break;

							case DESCENDING:
								comparator = new IdDescendingComparatorCustomer();
								break;
							}

							break;

						case NAME:

							switch (order) {

							case ASCENDING:
								comparator = new NameAscendingComparatorCustomer();
								break;

							case DESCENDING:
								comparator = new NameDescendingComparatorCustomer();
								break;
							}

							break;

						case SURNAME:

							switch (order) {

							case ASCENDING:
								comparator = new SurnameAscendingComparatorCustomer();
								break;

							case DESCENDING:
								comparator = new SurnameDescendingComparatorCustomer();
								break;
							}

							break;
						}

						customers = daoCustomer.listCustomers();
						customers.sort(comparator);

						for (int i = 0; i < customers.size(); i++) {
							System.out.println("Id: " + customers.get(i).getId() + ", nome: "
									+ customers.get(i).getName() + ", sobrenome: " + customers.get(i).getSurname());
							for (int j = 0; j < customers.get(i).getAddresses().size(); j++) {
								System.out.println("Logradouro: "
										+ customers.get(i).getAddresses().get(j).getPublicPlace() + ", n�mero: "
										+ customers.get(i).getAddresses().get(j).getPlaceNumber() + ", telefone: "
										+ customers.get(i).getAddresses().get(j).getPhoneNumber());
							}
						}
						System.out.println("");

						break;

					case EDIT:
						// inicia subMenuEditCustomer para edi��o de Cliente;
						do {
							do {
								try {
									System.out.println("Selecione uma das seguintes op��es:\n");
									System.out.println("1 - Alterar o nome do cliente.");
									System.out.println("2 - Alterar o sobrenome do cliente.");
									System.out.println("3 - Alterar o todos os dados do cliente.");
									System.out.println("4 - Voltar Menu Principal.");

									subMenuEditCustomer = SubMenuEditCustomer.values()[Integer.parseInt(sc.next()) - 1];
									condition = false;
									System.out.println();

								} catch (NumberFormatException exception) {
									System.err.println("\nFavor informar um n�mero das op��es acima.\n");
									condition = true;
								} catch (IndexOutOfBoundsException exception) {
									System.err.println("\nOp��o inv�lida.\n");
									condition = true;
								} catch (NullPointerException exception) {
									System.err.println("\nErro ao acessar o objeto nulo.\n");
									condition = true;
								}
							} while (condition);

							switch (subMenuEditCustomer) {

							case NAME:
								do {
									try {

										customers = daoCustomer.listCustomers();
										daoCustomer.listCustomers();

										System.out.println("Informe o c�digo do cliente para alterar:");
										customer = customers.get(Integer.parseInt(sc.next()) - 1);

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um n�mero das op��es acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOp��o inv�lida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo nome do cliente:");
								sc.nextLine();
								customer.setName(sc.nextLine());

								daoCustomer.updateCustomer(customer);

								break;

							case SURNAME:
								do {
									try {

										customers = daoCustomer.listCustomers();
										daoCustomer.listCustomers();

										System.out.println("Informe o c�digo do cliente para alterar:");
										customer = customers.get(Integer.parseInt(sc.next()) - 1);

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um n�mero das op��es acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOp��o inv�lida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo sobrenome do cliente:");
								sc.nextLine();
								customer.setSurname(sc.nextLine());

								daoCustomer.updateCustomer(customer);

								break;

							case ALL:
								do {
									try {

										customers = daoCustomer.listCustomers();
										daoCustomer.listCustomers();

										System.out.println("Informe o c�digo do cliente para alterar:");
										customer = customers.get(Integer.parseInt(sc.next()) - 1);

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um n�mero das op��es acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOp��o inv�lida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo nome do cliente:");
								sc.nextLine();
								customer.setName(sc.nextLine());

								System.out.println("Informe o novo sobrenome do cliente:");
								customer.setSurname(sc.nextLine());

								daoCustomer.updateCustomer(customer);

								break;

							default:
								break;
							}
						} while (subMenuEditCustomer != SubMenuEditCustomer.EXIT);
						// final subMenuEditCustomer para edi��o de Cliente
						break;

					case DELETE:
						do {
							try {

								daoCustomer.listCustomers();
								customers = daoCustomer.listCustomers();
								System.out.println("Informe o c�digo do cliente para excluir:");
								customer = customers.get(Integer.parseInt(sc.next()) - 1);

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um n�mero das op��es acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOp��o inv�lida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						daoCustomer.deleteCustomer(customer);

						break;

					default:
						break;
					}
				} while (subMenu != SubMenu.EXIT);
				// final do subMenu para Cliente
				break;

			// Inicia subMenu escolha Endere�o
			// inicia subMenu - escolher a��o CRUD Endere�os - Inserir, Listar,
			// Editar, Excluir e Voltar Menu Principal.
			case ADDRESS:
				addresses = new ArrayList<Address>();
				Address address = new Address();
				do {
					do {
						try {
							System.out.println("Selecione uma das seguintes op��es:\n");
							System.out.println("1 - Inserir Endere�o.");
							System.out.println("2 - Listar Endere�os.");
							System.out.println("3 - Editar Endere�o.");
							System.out.println("4 - Excluir Endere�o.");
							System.out.println("5 - Voltar Menu Principal.");

							subMenu = SubMenu.values()[Integer.parseInt(sc.next()) - 1];
							condition = false;
							System.out.println();

						} catch (NumberFormatException exception) {
							System.err.println("\nFavor informar um n�mero das op��es acima.\n");
							condition = true;
						} catch (IndexOutOfBoundsException exception) {
							System.err.println("\nOp��o inv�lida.\n");
							condition = true;
						} catch (NullPointerException exception) {
							System.err.println("\nErro ao acessar o objeto nulo.\n");
							condition = true;
						}
					} while (condition);

					switch (subMenu) {

					case INSERT:
						System.out.println("Informe o logradouro:");
						sc.nextLine();
						String publicPlace = sc.nextLine();

						System.out.println("Informe o n�mero do endere�o:");
						short placeNumber = Short.parseShort(sc.next());

						System.out.println("Informe o n�mero do telefone:");
						System.out.println("Formato: (xx)xxxxx-xxxx");
						sc.nextLine();
						String phoneNumber = sc.nextLine();

						address.setPublicPlace(publicPlace);
						address.setPlaceNumber(placeNumber);
						address.setPhoneNumber(phoneNumber);

						daoAddress.insertAddress(address);

						System.out.print("\n");

						break;

					case LIST:
						AttributeAddress attribute = null;
						Comparator<Address> comparator = null;
						Order order = null;
						do {
							try {
								System.out.println("Selecione uma das seguintes op��es:\n");
								System.out.println("1 - Listar Endere�os pelo Id.");
								System.out.println("2 - Listar Endere�os pelo Logradouro.");
								System.out.println("3 - Voltar Menu Principal.");

								attribute = AttributeAddress.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um n�mero das op��es acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOp��o inv�lida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);
						do {
							try {
								System.out.println("Selecione uma das seguintes op��es:\n");
								System.out.println("1 - Listar em Ordem Ascendente.");
								System.out.println("2 - Listar em Ordem Descendente.");

								order = Order.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um n�mero das op��es acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOp��o inv�lida.\n");
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
								comparator = new IdAscendingComparatorAddress();
								break;

							case DESCENDING:
								comparator = new IdDescendingComparatorAddress();
								break;
							}

							break;

						case PUBLICPLACE:

							switch (order) {

							case ASCENDING:
								comparator = new NameAscendingComparatorAddress();
								break;

							case DESCENDING:
								comparator = new NameDescendingComparatorAddress();
								break;
							}

							break;

						default:
							break;
						}

						addresses = daoAddress.listAddresses();
						addresses.sort(comparator);

						for (int i = 0; i < addresses.size(); i++) {
							System.out.println("Id: " + addresses.get(i).getId() + ", logradouro: "
									+ addresses.get(i).getPublicPlace() + ", n�mero: "
									+ addresses.get(i).getPlaceNumber() + ", telefone: "
									+ addresses.get(i).getPhoneNumber());
						}
						System.out.println("");

						break;

					case EDIT:
						// inicia subMenuEditAddress para edi��o de Endere�os;
						do {
							do {
								try {
									System.out.println("Selecione uma das seguintes op��es:\n");
									System.out.println("1 - Alterar o logradouro.");
									System.out.println("2 - Alterar o n�mero do endere�o.");
									System.out.println("3 - Alterar o n�mero do telefone.");
									System.out.println("4 - Alterar todos os dados.");
									System.out.println("5 - Voltar Menu Principal.");

									subMenuEditAddress = SubMenuEditAddress.values()[Integer.parseInt(sc.next()) - 1];
									condition = false;
									System.out.println();

								} catch (NumberFormatException exception) {
									System.err.println("\nFavor informar um n�mero das op��es acima.\n");
									condition = true;
								} catch (IndexOutOfBoundsException exception) {
									System.err.println("\nOp��o inv�lida.\n");
									condition = true;
								} catch (NullPointerException exception) {
									System.err.println("\nErro ao acessar o objeto nulo.\n");
									condition = true;
								}
							} while (condition);

							switch (subMenuEditAddress) {

							case PUBLICPLACE:
								do {
									try {

										addresses = daoAddress.listAddresses();
										daoAddress.listAddresses();

										System.out.println("Informe o c�digo do endere�o para alterar:");
										address = addresses.get(Integer.parseInt(sc.next()) - 1);

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um n�mero das op��es acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOp��o inv�lida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo logradouro:");
								sc.nextLine();
								address.setPublicPlace(sc.nextLine());

								daoAddress.updateAddress(address);

								break;

							case NUMBERPLACE:
								do {
									try {

										addresses = daoAddress.listAddresses();
										daoAddress.listAddresses();

										System.out.println("Informe o c�digo do endere�o para alterar:");
										address = addresses.get(Integer.parseInt(sc.next()) - 1);

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um n�mero das op��es acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOp��o inv�lida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo n�mero do endere�o:");
								sc.nextLine();
								address.setPlaceNumber(Short.parseShort(sc.next()));

								daoAddress.updateAddress(address);

								break;

							case PHONENUMBER:
								do {
									try {

										addresses = daoAddress.listAddresses();
										daoAddress.listAddresses();

										System.out.println("Informe o c�digo do endere�o para alterar:");
										address = addresses.get(Integer.parseInt(sc.next()) - 1);

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um n�mero das op��es acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOp��o inv�lida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo n�mero de telefone:");
								System.out.println("Formato: (xx)xxxxx-xxxx");
								sc.nextLine();

								address.setPhoneNumber(sc.nextLine());

								daoAddress.updateAddress(address);

								break;

							case ALL:
								do {
									try {

										addresses = daoAddress.listAddresses();
										daoAddress.listAddresses();

										System.out.println("Informe o c�digo do endere�o para alterar:");
										address = addresses.get(Integer.parseInt(sc.next()) - 1);

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um n�mero das op��es acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOp��o inv�lida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o logradouro:");
								sc.nextLine();
								address.setPublicPlace(sc.nextLine());

								System.out.println("Informe o n�mero do endere�o:");
								address.setPlaceNumber(Short.parseShort(sc.next()));

								System.out.println("Informe o n�mero do telefone:");
								System.out.println("Formato: (xx)xxxxx-xxxx");
								address.setPhoneNumber(sc.nextLine());

								daoAddress.updateAddress(address);

								System.out.print("\n");

								break;

							default:
								break;
							}
						} while (subMenuEditAddress != SubMenuEditAddress.EXIT);
						// final subMenuEditAddress para edi��o de Endere�o
						break;

					case DELETE:
						do {
							try {

								daoAddress.listAddresses();
								addresses = daoAddress.listAddresses();
								System.out.println("Informe o c�digo do endere�o para excluir:");
								address = addresses.get(Integer.parseInt(sc.next()) - 1);

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um n�mero das op��es acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOp��o inv�lida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						daoAddress.deleteAddress(address);

						break;

					default:
						break;
					}
				} while (subMenu != SubMenu.EXIT);
				// final do subMenu para Endere�os
				break;

			// Inicia subMenuLinkAddress vincular/desvincular cliente/endere�o
			case CUSTOMERADDRESS:
				customers = new ArrayList<Customer>();
				customer = new Customer();
				addresses = new ArrayList<Address>();
				address = new Address();

				do {
					do {
						try {
							System.out.println("Selecione uma das seguintes op��es:\n");
							System.out.println("1 - Vincular Cliente com Endere�o.");
							System.out.println("2 - Desvincular Cliente de Endere�o.");
							System.out.println("3 - Voltar Menu Principal.");

							subMenuLinkAddress = SubMenuLinkAddress.values()[Integer.parseInt(sc.next()) - 1];
							condition = false;
							System.out.println();

						} catch (NumberFormatException exception) {
							System.err.println("\nFavor informar um n�mero das op��es acima.\n");
							condition = true;
						} catch (IndexOutOfBoundsException exception) {
							System.err.println("\nOp��o inv�lida.\n");
							condition = true;
						} catch (NullPointerException exception) {
							System.err.println("\nErro ao acessar o objeto nulo.\n");
							condition = true;
						}
					} while (condition);

					switch (subMenuLinkAddress) {

					case LINK:

						customers = daoCustomer.listCustomers();
						customers.sort(new IdAscendingComparatorCustomer());

						for (int i = 0; i < customers.size(); i++) {
							System.out.println("Id: " + customers.get(i).getId() + ", nome: "
									+ customers.get(i).getName() + ", sobrenome: " + customers.get(i).getSurname());
						}
						System.out.println("");

						System.out.println("Informe o c�digo do cliente:");
						customer = customers.get(sc.nextInt() - 1);

						addresses = daoAddress.listAddresses();
						addresses.sort(new IdAscendingComparatorAddress());

						for (int i = 0; i < addresses.size(); i++) {
							System.out.println("Id: " + addresses.get(i).getId() + ", logradouro: "
									+ addresses.get(i).getPublicPlace() + ", n�mero: "
									+ addresses.get(i).getPlaceNumber() + ", telefone: "
									+ addresses.get(i).getPhoneNumber());
						}
						System.out.println("");

						System.out.println("Informe o c�digo do endere�o:");
						address = addresses.get(sc.nextInt() - 1);

						customer.addAddresses(address);

						daoCustomer.updateCustomer(customer);

						System.out.print("\n");

						break;

					case UNLINK:
						System.out.println("Listagem de clientes:\n");
						customers = daoCustomer.listCustomers();
						customers.sort(new IdAscendingComparatorCustomer());

						for (int i = 0; i < customers.size(); i++) {
							System.out.println("Id: " + customers.get(i).getId() + ", nome: "
									+ customers.get(i).getName() + ", sobrenome: " + customers.get(i).getSurname());
						}
						System.out.println("");
						System.out.println("Informe o c�digo do cliente:");
						customer = customers.get(sc.nextInt() - 1);

						System.out.println("Listagem de endere�os:\n");
						addresses = daoAddress.listAddresses();
						addresses.sort(new IdAscendingComparatorAddress());

						for (int i = 0; i < addresses.size(); i++) {
							System.out.println("Id: " + addresses.get(i).getId() + ", logradouro: "
									+ addresses.get(i).getPublicPlace() + ", n�mero: "
									+ addresses.get(i).getPlaceNumber() + ", telefone: "
									+ addresses.get(i).getPhoneNumber());
						}
						System.out.println("");

						System.out.println("Informe o c�digo do endere�o:");
						address = addresses.get(sc.nextInt() - 1);

						customer.removeAddresses(address);

						daoCustomer.updateCustomer(customer);

						System.out.print("\n");

						break;

					default:
						break;
					}
				} while (subMenuLinkAddress != SubMenuLinkAddress.EXIT);
				// final do subMenu link/unlink Cliente e Endere�o
				break;

			// inicio subMenu escolha Produto - escolher a��o CRUD Produtos - Inserir,
			// Listar, Editar, Excluir e Voltar Menu Principal.
			case PRODUCT:
				products = new ArrayList<Product>();
				Product product = new Product();
				// Long idProduct = null;
				do {
					do {
						try {
							System.out.println("Selecione uma das seguintes op��es:\n");
							System.out.println("1 - Inserir Produto.");
							System.out.println("2 - Listar Produtos.");
							System.out.println("3 - Editar Produto.");
							System.out.println("4 - Excluir Produto.");
							System.out.println("5 - Voltar Menu Principal.");

							subMenu = SubMenu.values()[Integer.parseInt(sc.next()) - 1];
							condition = false;
							System.out.println();
						} catch (NumberFormatException exception) {
							System.err.println("\nFavor informar um n�mero das op��es acima.\n");
							condition = true;
						} catch (IndexOutOfBoundsException exception) {
							System.err.println("\nOp��o inv�lida.\n");
							condition = true;
						} catch (NullPointerException exception) {
							System.err.println("\nErro ao acessar o objeto nulo.\n");
							condition = true;
						}
					} while (condition);

					switch (subMenu) {

					case INSERT:
						System.out.println("Informe o nome do produto:");
						sc.nextLine();
						String name = sc.nextLine();

						System.out.println("Informe o c�digo do produto:");
						String code = sc.nextLine();

						System.out.println("Informe a descri��o do produto:");
						String description = sc.nextLine();

						System.out.print("\n");
						product.setName(name);
						product.setCode(code);
						product.setDescription(description);
						daoProduct.insertProduct(product);

						break;

					case LIST:
						AttributeProduct attribute = null;
						Comparator<Product> comparator = null;
						Order order = null;
						do {
							try {
								System.out.println("Selecione uma das seguintes op��es:\n");
								System.out.println("1 - Listar Produtos pelo Id.");
								System.out.println("2 - Listar Produtos pelo Nome.");
								System.out.println("3 - Listar Produtos pelo C�digo.");

								attribute = AttributeProduct.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um n�mero das op��es acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOp��o inv�lida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);
						do {
							try {
								System.out.println("Selecione uma das seguintes op��es:\n");
								System.out.println("1 - Listar em Ordem Ascendente.");
								System.out.println("2 - Listar em Ordem Descendente.");

								order = Order.values()[Integer.parseInt(sc.next()) - 1];
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um n�mero das op��es acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOp��o inv�lida.\n");
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
								comparator = new IdAscendingComparatorProduct();
								break;

							case DESCENDING:
								comparator = new IdDescendingComparatorProduct();
								break;
							}

							break;

						case NAME:

							switch (order) {

							case ASCENDING:
								comparator = new NameAscendingComparatorProduct();
								break;

							case DESCENDING:
								comparator = new NameDescendingComparatorProduct();
								break;
							}

							break;

						case CODE:

							switch (order) {

							case ASCENDING:
								comparator = new CodeAscendingComparatorProduct();
								break;

							case DESCENDING:
								comparator = new CodeDescendingComparatorProduct();
								break;
							}

							break;
						}

						products = daoProduct.listProducts();
						// ordena��o pelo comparador abaixo
						products.sort(comparator);

						for (int i = 0; i < products.size(); i++) {
							System.out.println("Id: " + products.get(i).getId() + ", nome: " + products.get(i).getName()
									+ ", c�digo: " + products.get(i).getCode() + ", descri��o: "
									+ products.get(i).getDescription());
						}
						System.out.println("");
						// listagem de acordo com o select

						break;

					case EDIT:

						// inicia subMenuEditProduto para edi��o;
						do {
							do {
								try {
									System.out.println("Selecione uma das seguintes op��es:\n");
									System.out.println("1 - Alterar o nome do produto.");
									System.out.println("2 - Alterar o c�digo do produto.");
									System.out.println("3 - Alterar o descri��o do produto.");
									System.out.println("4 - Alterar o todos os dados do produto.");
									System.out.println("5 - Voltar Menu Principal.");

									subMenuEditProduct = SubMenuEditProduct.values()[Integer.parseInt(sc.next()) - 1];
									condition = false;
									System.out.println();

								} catch (NumberFormatException exception) {
									System.err.println("\nFavor informar um n�mero das op��es acima.\n");
									condition = true;
								} catch (IndexOutOfBoundsException exception) {
									System.err.println("\nOp��o inv�lida.\n");
									condition = true;
								} catch (NullPointerException exception) {
									System.err.println("\nErro ao acessar o objeto nulo.\n");
									condition = true;
								}
							} while (condition);

							switch (subMenuEditProduct) {

							case NAME:
								do {
									try {

										products = daoProduct.listProducts();
										daoProduct.listProducts();

										System.out.println("Informe o c�digo do produto:");
										product = products.get(Integer.parseInt(sc.next()) - 1);
										condition = false;
										System.out.println();

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um n�mero das op��es acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOp��o inv�lida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo nome do produto:");
								sc.nextLine();
								product.setName(sc.nextLine());
								daoProduct.updateProduct(product);

								break;

							case CODE:
								do {
									try {

										products = daoProduct.listProducts();
										daoProduct.listProducts();

										System.out.println("Informe o c�digo do produto:");
										product = products.get(Integer.parseInt(sc.next()) - 1);
										condition = false;
										System.out.println();
									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um n�mero das op��es acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOp��o inv�lida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo c�digo do produto:");
								sc.nextLine();
								product.setCode(sc.nextLine());

								daoProduct.updateProduct(product);

								break;

							case DESCRIPTION:
								do {
									try {

										products = daoProduct.listProducts();
										daoProduct.listProducts();

										System.out.println("Informe o c�digo do produto:");
										product = products.get(Integer.parseInt(sc.next()) - 1);
										condition = false;
										System.out.println();

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um n�mero das op��es acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOp��o inv�lida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe a nova descri��o do produto:");
								sc.nextLine();
								product.setDescription(sc.nextLine());

								daoProduct.updateProduct(product);

								break;

							case ALL:
								do {
									try {

										products = daoProduct.listProducts();
										daoProduct.listProducts();

										System.out.println("Informe o c�digo do produto:");
										product = products.get(Integer.parseInt(sc.next()) - 1);
										condition = false;
										System.out.println();

									} catch (NumberFormatException exception) {
										System.err.println("\nFavor informar um n�mero das op��es acima.\n");
										condition = true;
									} catch (IndexOutOfBoundsException exception) {
										System.err.println("\nOp��o inv�lida.\n");
										condition = true;
									} catch (NullPointerException exception) {
										System.err.println("\nErro ao acessar o objeto nulo.\n");
										condition = true;
									}
								} while (condition);

								System.out.println("Informe o novo nome do produto:");
								sc.nextLine();
								product.setName(sc.nextLine());

								System.out.println("Informe o c�digo do produto:");
								product.setCode(sc.nextLine());

								System.out.println("Informe a nova descri��o do produto:");
								product.setDescription(sc.nextLine());

								daoProduct.updateProduct(product);

								break;

							default:
								break;
							}
							break;
						} while (subMenuEditProduct != SubMenuEditProduct.EXIT);
						// final subMenuEditProduct para edi��o
						break;

					case DELETE:
						do {
							try {

								products = daoProduct.listProducts();
								daoProduct.listProducts();

								System.out.println("Informe o c�digo do produto para excluir:");
								product = products.get(Integer.parseInt(sc.next()) - 1);
								condition = false;
								System.out.println();

							} catch (NumberFormatException exception) {
								System.err.println("\nFavor informar um n�mero das op��es acima.\n");
								condition = true;
							} catch (IndexOutOfBoundsException exception) {
								System.err.println("\nOp��o inv�lida.\n");
								condition = true;
							} catch (NullPointerException exception) {
								System.err.println("\nErro ao acessar o objeto nulo.\n");
								condition = true;
							}
						} while (condition);

						daoProduct.deleteProduct(product);

						break;

					default:
						break;
					}
				} while (subMenu != SubMenu.EXIT);
				// final do subMenu para Produto
				break;
			/*
			 * // Inicia Menu escolha Pedido case ORDER: SimpleDateFormat sdf1 = new
			 * SimpleDateFormat("dd/MM/yyyy"); List<OrderItem> items = new
			 * ArrayList<OrderItem>(); // inicia subMenu - escolher a��o CRUD Pedido -
			 * Inserir, Listar, // Editar, Excluir e Voltar Menu Principal. int idOrder = 0;
			 * do { do { try { System.out.println("Selecione uma das seguintes op��es:\n");
			 * System.out.println("1 - Inserir Pedido.");
			 * System.out.println("2 - Listar Pedidos.");
			 * System.out.println("3 - Editar Pedido.");
			 * System.out.println("4 - Excluir Pedido.");
			 * System.out.println("5 - Voltar Menu Principal.");
			 * 
			 * subMenu = SubMenu.values()[Integer.parseInt(sc.next()) - 1]; condition =
			 * false; System.out.println(); } catch (NumberFormatException exception) {
			 * System.err.println("\nFavor informar um n�mero das op��es acima.\n");
			 * condition = true; } catch (IndexOutOfBoundsException exception) {
			 * System.err.println("\nOp��o inv�lida.\n"); condition = true; } catch
			 * (NullPointerException exception) {
			 * System.err.println("\nErro ao acessar o objeto nulo.\n"); condition = true; }
			 * } while (condition);
			 * 
			 * switch (subMenu) {
			 * 
			 * case INSERT: // parei aqui
			 * System.out.println("Informe o c�digo do cliente:"); int customerId =
			 * sc.nextInt(); Date date = new Date();
			 * 
			 * Customer customer = new Customer(customerId);
			 * 
			 * for (int i = 0; i < items.size(); i++) {
			 * System.out.println("Informe o c�digo do produto:"); int productId =
			 * sc.nextInt();
			 * 
			 * System.out.println("Informe a quantidade do produto:"); float quantity =
			 * sc.nextFloat();
			 * 
			 * System.out.println("Informe o pre�o do produto:"); float price =
			 * sc.nextFloat();
			 * 
			 * }
			 * 
			 * 
			 * daoCustomerOrder.insertCustomerOrder(CustomerId, date, items);
			 * System.out.print("\n");
			 * 
			 * break;
			 * 
			 * case LIST: AttributeCustomer attribute = null; Comparator<Customer>
			 * comparator = null; Order order = null; do { try {
			 * System.out.println("Selecione uma das seguintes op��es:\n");
			 * System.out.println("1 - Listar Clientes pelo Id.");
			 * System.out.println("2 - Listar Clientes pelo Nome.");
			 * System.out.println("3 - Listar Clientes pelo Sobrenome.");
			 * 
			 * attribute = AttributeCustomer.values()[Integer.parseInt(sc.next()) - 1];
			 * condition = false; System.out.println(); } catch (NumberFormatException
			 * exception) {
			 * System.err.println("\nFavor informar um n�mero das op��es acima.\n");
			 * condition = true; } catch (IndexOutOfBoundsException exception) {
			 * System.err.println("\nOp��o inv�lida.\n"); condition = true; } catch
			 * (NullPointerException exception) {
			 * System.err.println("\nErro ao acessar o objeto nulo.\n"); condition = true; }
			 * } while (condition); do { try {
			 * System.out.println("Selecione uma das seguintes op��es:\n");
			 * System.out.println("1 - Listar em Ordem Ascendente.");
			 * System.out.println("2 - Listar em Ordem Descendente.");
			 * 
			 * order = Order.values()[Integer.parseInt(sc.next()) - 1]; condition = false;
			 * System.out.println(); } catch (NumberFormatException exception) {
			 * System.err.println("\nFavor informar um n�mero das op��es acima.\n");
			 * condition = true; } catch (IndexOutOfBoundsException exception) {
			 * System.err.println("\nOp��o inv�lida.\n"); condition = true; } catch
			 * (NullPointerException exception) {
			 * System.err.println("\nErro ao acessar o objeto nulo.\n"); condition = true; }
			 * } while (condition);
			 * 
			 * switch (attribute) {
			 * 
			 * case ID:
			 * 
			 * switch (order) {
			 * 
			 * case ASCENDING: comparator = new IdAscendingComparatorCustomer(); break;
			 * 
			 * case DESCENDING: comparator = new IdDescendingComparatorCustomer(); break; }
			 * 
			 * break;
			 * 
			 * case NAME:
			 * 
			 * switch (order) {
			 * 
			 * case ASCENDING: comparator = new NameAscendingComparatorCustomer(); break;
			 * 
			 * case DESCENDING: comparator = new NameDescendingComparatorCustomer(); break;
			 * }
			 * 
			 * break;
			 * 
			 * case SURNAME:
			 * 
			 * switch (order) {
			 * 
			 * case ASCENDING: comparator = new SurnameAscendingComparatorCustomer(); break;
			 * 
			 * case DESCENDING: comparator = new SurnameDescendingComparatorCustomer();
			 * break; }
			 * 
			 * break; }
			 * 
			 * List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
			 * customerOrders = daoCustomerOrder.listCustomerOrders();
			 * customerOrders.sort(comparator);
			 * 
			 * for (int i = 0; i < customerOrders.size(); i++) { System.out.println("Id: " +
			 * customerOrders.get(i).getIdCustomerOrders() + ", nome: " +
			 * customerOrders.get(i).getName() + ", sobrenome: " +
			 * customerOrders.get(i).getSurname() + ", telefone: " +
			 * customerOrders.get(i).getPhoneNumber()); } System.out.println("");
			 * 
			 * break;
			 * 
			 * case EDIT:
			 * 
			 * // inicia subMenuEditCustomerOrder para edi��o; do { do { try {
			 * System.out.println("Selecione uma das seguintes op��es:\n");
			 * System.out.println("1 - Alterar o nome do cliente.");
			 * System.out.println("2 - Alterar o sobrenome do cliente.");
			 * System.out.println("3 - Alterar o telefone do cliente.");
			 * System.out.println("4 - Alterar o todos os dados do cliente.");
			 * System.out.println("5 - Voltar Menu Principal.");
			 * 
			 * subMenuEditCustomer =
			 * SubMenuEditCustomer.values()[Integer.parseInt(sc.next()) - 1]; condition =
			 * false; System.out.println(); } catch (NumberFormatException exception) {
			 * System.err.println("\nFavor informar um n�mero das op��es acima.\n");
			 * condition = true; } catch (IndexOutOfBoundsException exception) {
			 * System.err.println("\nOp��o inv�lida.\n"); condition = true; } catch
			 * (NullPointerException exception) {
			 * System.err.println("\nErro ao acessar o objeto nulo.\n"); condition = true; }
			 * } while (condition);
			 * 
			 * switch (subMenuEditCustomer) {
			 * 
			 * case NAME: do { try {
			 * System.out.println("Informe o c�digo do cliente para alterar:"); idCustomer =
			 * sc.nextInt(); } catch (NumberFormatException exception) {
			 * System.err.println("\nFavor informar um n�mero das op��es acima.\n");
			 * condition = true; } catch (IndexOutOfBoundsException exception) {
			 * System.err.println("\nOp��o inv�lida.\n"); condition = true; } catch
			 * (NullPointerException exception) {
			 * System.err.println("\nErro ao acessar o objeto nulo.\n"); condition = true; }
			 * } while (condition);
			 * 
			 * System.out.println("Informe o novo nome do cliente:"); sc.nextLine(); String
			 * newName = sc.nextLine();
			 * 
			 * daoCustomer.editCustomerName(idCustomer, newName);
			 * 
			 * break;
			 * 
			 * case SURNAME: do { try {
			 * System.out.println("Informe o c�digo do cliente para alterar:"); idCustomer =
			 * sc.nextInt(); } catch (NumberFormatException exception) {
			 * System.err.println("\nFavor informar um n�mero das op��es acima.\n");
			 * condition = true; } catch (IndexOutOfBoundsException exception) {
			 * System.err.println("\nOp��o inv�lida.\n"); condition = true; } catch
			 * (NullPointerException exception) {
			 * System.err.println("\nErro ao acessar o objeto nulo.\n"); condition = true; }
			 * } while (condition);
			 * 
			 * System.out.println("Informe o novo sobrenome do cliente:"); sc.nextLine();
			 * String newSurname = sc.nextLine();
			 * 
			 * daoCustomer.editCustomerSurname(idCustomer, newSurname);
			 * 
			 * break;
			 * 
			 * case PHONENUMBER: do { try {
			 * System.out.println("Informe o c�digo do cliente para alterar:"); idCustomer =
			 * sc.nextInt(); } catch (NumberFormatException exception) {
			 * System.err.println("\nFavor informar um n�mero das op��es acima.\n");
			 * condition = true; } catch (IndexOutOfBoundsException exception) {
			 * System.err.println("\nOp��o inv�lida.\n"); condition = true; } catch
			 * (NullPointerException exception) {
			 * System.err.println("\nErro ao acessar o objeto nulo.\n"); condition = true; }
			 * } while (condition);
			 * 
			 * System.out.println("Informe o novo n�mero de telefone do cliente:");
			 * sc.nextLine(); String newPhoneNumber = sc.nextLine();
			 * 
			 * daoCustomer.editCustomerPhoneNumber(idCustomer, newPhoneNumber);
			 * 
			 * break;
			 * 
			 * case ALL: do { try {
			 * System.out.println("Informe o c�digo do cliente para alterar:"); idCustomer =
			 * sc.nextInt(); } catch (NumberFormatException exception) {
			 * System.err.println("\nFavor informar um n�mero das op��es acima.\n");
			 * condition = true; } catch (IndexOutOfBoundsException exception) {
			 * System.err.println("\nOp��o inv�lida.\n"); condition = true; } catch
			 * (NullPointerException exception) {
			 * System.err.println("\nErro ao acessar o objeto nulo.\n"); condition = true; }
			 * } while (condition);
			 * 
			 * System.out.println("Informe o novo nome do cliente:"); sc.nextLine(); newName
			 * = sc.nextLine();
			 * 
			 * System.out.println("Informe o novo sobrenome do cliente:"); newSurname =
			 * sc.nextLine();
			 * 
			 * System.out.println("Informe o novo n�mero de telefone do cliente:");
			 * newPhoneNumber = sc.nextLine();
			 * 
			 * daoCustomer.editAllCustomerData(idCustomer, newName, newSurname,
			 * newPhoneNumber);
			 * 
			 * break; } } while (subMenuEditCustomer != SubMenuEditCustomer.EXIT); // final
			 * subMenuEditCustomerOrder para edi��o break;
			 * 
			 * case DELETE: do { try {
			 * System.out.println("Informe o c�digo do cliente para excluir:"); idCustomer =
			 * sc.nextInt(); } catch (NumberFormatException exception) {
			 * System.err.println("\nFavor informar um n�mero das op��es acima.\n");
			 * condition = true; } catch (IndexOutOfBoundsException exception) {
			 * System.err.println("\nOp��o inv�lida.\n"); condition = true; } catch
			 * (NullPointerException exception) {
			 * System.err.println("\nErro ao acessar o objeto nulo.\n"); condition = true; }
			 * } while (condition);
			 * 
			 * daoCustomer.removeCustomer(idCustomer);
			 * 
			 * break;
			 * 
			 * default: break; } break; } while (subMenu != SubMenu.EXIT);
			 * 
			 * // final do subMenu Order break;
			 */
			default:
				break;
			}

		} while (menu != Menu.EXIT);
		// final do Menu Geral.

		System.out.println("Saindo do Sistema...");
		System.out.println("Muito obrigado e volte sempre.");

		sc.close();

		/*
		 * //c�digo modelo do { System.out.println("Seja bem-vindo.\n");
		 * 
		 * System.out.println("Selecione uma das seguintes op��es:\n");
		 * System.out.println("0 - Inserir Usu�rios.");
		 * System.out.println("1 - Listar Usu�rios.");
		 * System.out.println("2 - Editar Usu�rios.");
		 * System.out.println("3 - Excluir Usu�rios.");
		 * System.out.println("4 - Sair do Sistema.");
		 * 
		 * subMenu = SubMenu.values()[Integer.parseInt(sc.next())];
		 * System.out.println();
		 * 
		 * switch (subMenu) {
		 * 
		 * case INSERT: System.out.println("Informe o nome completo do usu�rio:");
		 * sc.nextLine(); String name = sc.nextLine();
		 * 
		 * System.out.println("Informe a idade do usu�rio:"); int age = sc.nextInt();
		 * 
		 * System.out.println("Informe nome de usu�rio:"); String username = sc.next();
		 * 
		 * System.out.println("Informe a senha do usu�rio:"); String password =
		 * sc.next();
		 * 
		 * System.out.print("\n");
		 * 
		 * users.add(new user(name, age, username, password));
		 * 
		 * break; case LIST:
		 * 
		 * System.out.println("Selecione uma das seguintes op��es:\n");
		 * System.out.println("0 - Listar Usu�rios pelo Nome.");
		 * System.out.println("1 - Listar Usu�rios pela Idade.");
		 * System.out.println("2 - Listar Usu�rios pelo Nome de Usu�rio.");
		 * System.out.println("3 - Listar Usu�rios pela Senha.");
		 * 
		 * Attribute attribute = Attribute.values()[Integer.parseInt(sc.next())];
		 * 
		 * Comparator<user> comparator = null; Order order = null;
		 * 
		 * System.out.println("Selecione uma das seguintes op��es:\n");
		 * System.out.println("0 - Listar em Ordem Ascendente.");
		 * System.out.println("1 - Listar em Ordem Descendente.");
		 * 
		 * order = Order.values()[Integer.parseInt(sc.next())];
		 * 
		 * switch (attribute) {
		 * 
		 * case NAME:
		 * 
		 * switch (order) {
		 * 
		 * case ASCENDING: comparator = new NameAscendingComparatorCustomer(); break;
		 * 
		 * case DESCENDING: comparator = new NameDescendingComparatorCustomer(); break;
		 * }
		 * 
		 * break;
		 * 
		 * case AGE:
		 * 
		 * switch (order) {
		 * 
		 * case ASCENDING: comparator = new PasswordAscendingComparator(); break;
		 * 
		 * case DESCENDING: comparator = new PasswordDescendingComparator(); break; }
		 * 
		 * break;
		 * 
		 * case USERNAME:
		 * 
		 * switch (order) {
		 * 
		 * case ASCENDING: comparator = new AgeAscendingComparator(); break;
		 * 
		 * case DESCENDING: comparator = new AgeDescendingComparator(); break; }
		 * 
		 * break;
		 * 
		 * case PASSWORD:
		 * 
		 * switch (order) {
		 * 
		 * case ASCENDING: comparator = new UsernameAscendingComparator(); break;
		 * 
		 * case DESCENDING: comparator = new UsernameDescendingComparator(); break; }
		 * 
		 * break; }
		 * 
		 * listUsersOrdered(users, comparator);
		 * 
		 * break; case EDIT:
		 * 
		 * for (int i = 0; i < users.size(); i++) { System.out.println(i + " - " +
		 * users.get(i).getName()); }
		 * 
		 * System.out.println("Informe o c�digo do usu�rio:"); int code = sc.nextInt();
		 * 
		 * System.out.println("Informe o nome completo do usu�rio:"); sc.nextLine();
		 * name = sc.nextLine();
		 * 
		 * System.out.println("Informe a idade do usu�rio:"); age = sc.nextInt();
		 * 
		 * System.out.println("Informe nome de usu�rio:"); username = sc.next();
		 * 
		 * System.out.println("Informe a senha do usu�rio:"); password = sc.next();
		 * 
		 * System.out.print("\n");
		 * 
		 * users.get(code).setName(name); users.get(code).setAge(age);
		 * users.get(code).setUsername(username); users.get(code).setUsername(password);
		 * 
		 * break; case DELETE:
		 * 
		 * for (int i = 0; i < users.size(); i++) { System.out.println(i + " - " +
		 * users.get(i).getName()); }
		 * 
		 * System.out.println("Informe o c�digo do usu�rio para excluir:"); code =
		 * sc.nextInt();
		 * 
		 * users.remove(code); break;
		 * 
		 * default: System.out.println("Por favor tente novamente."); break; } } while
		 * (subMenu != SubMenu.EXIT);
		 * 
		 * sc.close();
		 * 
		 * System.out.println("Saindo do Sistema...");
		 * System.out.println("Muito obrigado e volte sempre."); }
		 * 
		 * /* c�digo antigo que est� sendo substitu�do pelo CustomerDAO private static
		 * void listCustomers(ArrayList<Customer> customers) {
		 * 
		 * for (int i = 0; i < customers.size(); i++) {
		 * 
		 * Customer customer = customers.get(i);
		 * 
		 * System.out.println("Nome: " + customer.getName());
		 * System.out.println("Sobrenome: " + customer.getSurname());
		 * System.out.println("Telefone do Cliente: " + customer.getPhoneNumber());
		 * System.out.print("\n"); } }
		 * 
		 * private static void listCustomersOrdered(ArrayList<Customer> customers,
		 * Comparator<Customer> order) { customers.sort(order);
		 * listCustomers(customers); }
		 */

	}
}