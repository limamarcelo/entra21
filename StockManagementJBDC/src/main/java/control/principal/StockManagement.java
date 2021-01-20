package control.principal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
import model.dao.customerOrder.CustomerOrderDAO;
import model.dao.customerOrder.CustomerOrderDAOSGBDImpl;
import model.dao.product.ProductDAO;
import model.dao.product.ProductDAOSGBDImpl;
import model.entity.customer.Customer;
import model.entity.order.CustomerOrder;
import model.entity.order.item.OrderItem;
import model.entity.product.Product;
import model.enumeration.menu.Menu;
import model.enumeration.menu.attributes.AttributeCustomer;
import model.enumeration.menu.attributes.AttributeProduct;
import model.enumeration.menu.ordination.Order;
import model.enumeration.menu.submenu.SubMenu;
import model.enumeration.menu.submenu.SubMenuEditCustomer;
import model.enumeration.menu.submenu.SubMenuEditCustomerOrder;
import model.enumeration.menu.submenu.SubMenuEditProduct;

public class StockManagement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Menu menu = null;
		SubMenu subMenu = null;
		SubMenuEditCustomer subMenuEditCustomer = null;
		SubMenuEditCustomerOrder subMenuEditCustomerOrder = null;
		SubMenuEditProduct subMenuEditProduct = null;
		CustomerDAO daoCustomer = new CustomerDAOSGBDImpl();
		ProductDAO daoProduct = new ProductDAOSGBDImpl();
		CustomerOrderDAO daoCustomerOrder = new CustomerOrderDAOSGBDImpl();
		boolean condition;

		// inicia Menu Principal - escolher Cliente, Produto ou Pedido
		System.out.println("Seja bem-vindo.\n");
		do {
			do {
				try {
					System.out.println("Selecione uma das seguintes op��es:\n");
					System.out.println("1 - Cliente");
					System.out.println("2 - Produto");
					System.out.println("3 - Pedido");
					System.out.println("4 - Sair");

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
			} while (condition == true);

			switch (menu) {

			// Inicia subMenu escolha Cliente
			case CUSTOMER:

				// inicia subMenu - escolher a��o CRUD Clientes - Inserir, Listar,
				// Editar, Excluir e Voltar Menu Principal.
				int idCustomer = 0;
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
					} while (condition == true);

					switch (subMenu) {

					case INSERT:
						System.out.println("Informe o nome do cliente:");
						sc.nextLine();
						String customerName = sc.nextLine();

						System.out.println("Informe o sobrenome do cliente:");
						String customerSurname = sc.nextLine();

						System.out.println("Informe o telefone do cliente:");
						String phoneNumberCustomer = sc.nextLine();
						daoCustomer.insertCustomer(customerName, customerSurname, phoneNumberCustomer);
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
						} while (condition == true);
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
						} while (condition == true);

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

						List<Customer> customers = new ArrayList<Customer>();
						customers = daoCustomer.listCustomers();
						customers.sort(comparator);

						for (int i = 0; i < customers.size(); i++) {
							System.out.println("Id: " + customers.get(i).getId() + ", nome: "
									+ customers.get(i).getName() + ", sobrenome: " + customers.get(i).getSurname()
									+ ", telefone: " + customers.get(i).getPhoneNumber());
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
									System.out.println("3 - Alterar o telefone do cliente.");
									System.out.println("4 - Alterar o todos os dados do cliente.");
									System.out.println("5 - Voltar Menu Principal.");

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
							} while (condition == true);

							switch (subMenuEditCustomer) {

							case NAME:
								do {
									try {
										System.out.println("Informe o c�digo do cliente para alterar:");
										idCustomer = Integer.parseInt(sc.next());
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
								} while (condition == true);

								System.out.println("Informe o novo nome do cliente:");
								sc.nextLine();
								String newName = sc.nextLine();

								daoCustomer.editCustomerName(idCustomer, newName);

								break;

							case SURNAME:
								do {
									try {
										System.out.println("Informe o c�digo do cliente para alterar:");
										idCustomer = Integer.parseInt(sc.next());
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
								} while (condition == true);

								System.out.println("Informe o novo sobrenome do cliente:");
								sc.nextLine();
								String newSurname = sc.nextLine();

								daoCustomer.editCustomerSurname(idCustomer, newSurname);

								break;

							case PHONENUMBER:
								do {
									try {
										System.out.println("Informe o c�digo do cliente para alterar:");
										idCustomer = Integer.parseInt(sc.next());
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
								} while (condition == true);

								System.out.println("Informe o novo n�mero de telefone do cliente:");
								sc.nextLine();
								String newPhoneNumber = sc.nextLine();

								daoCustomer.editCustomerPhoneNumber(idCustomer, newPhoneNumber);

								break;

							case ALL:
								do {
									try {
										System.out.println("Informe o c�digo do cliente para alterar:");
										idCustomer = Integer.parseInt(sc.next());
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
								} while (condition == true);

								System.out.println("Informe o novo nome do cliente:");
								sc.nextLine();
								newName = sc.nextLine();

								System.out.println("Informe o novo sobrenome do cliente:");
								newSurname = sc.nextLine();

								System.out.println("Informe o novo n�mero de telefone do cliente:");
								newPhoneNumber = sc.nextLine();

								daoCustomer.editAllCustomerData(idCustomer, newName, newSurname, newPhoneNumber);

								break;
							}
						} while (subMenuEditCustomer != SubMenuEditCustomer.EXIT);
						// final subMenuEditCustomer para edi��o de Cliente
						break;

					case DELETE:
						do {
							try {
								System.out.println("Informe o c�digo do cliente para excluir:");
								idCustomer = Integer.parseInt(sc.next());
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
						} while (condition == true);

						daoCustomer.removeCustomer(idCustomer);

						break;

					default:
						break;
					}
				} while (subMenu != SubMenu.EXIT);
				// final do subMenu para Cliente
				break;

			// inicio subMenu escolha Produto - escolher a��o CRUD Produtos - Inserir,
			// Listar,
			// Editar, Excluir e Voltar Menu Principal.
			case PRODUCT:
				int idProduct = 0;
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
					} while (condition == true);

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

						daoProduct.insertProduct(name, code, description);

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
						} while (condition == true);
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
						} while (condition == true);

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

						List<Product> products = new ArrayList<Product>();
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
						// daoProduct.listProducts();
						// System.out.println("");

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
							} while (condition == true);

							switch (subMenuEditProduct) {

							case NAME:
								do {
									try {
										System.out.println("Informe o c�digo do produto:");
										idProduct = Integer.parseInt(sc.next());
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
								} while (condition == true);

								System.out.println("Informe o novo nome do produto:");
								sc.nextLine();
								String newName = sc.nextLine();

								daoProduct.editProductName(idProduct, newName);

								break;

							case CODE:
								do {
									try {
										System.out.println("Informe o c�digo do produto:");
										idProduct = Integer.parseInt(sc.next());
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
								} while (condition == true);

								System.out.println("Informe o novo c�digo do produto:");
								sc.nextLine();
								String newCode = sc.nextLine();

								daoProduct.editProductCode(idProduct, newCode);

								break;

							case DESCRIPTION:
								do {
									try {
										System.out.println("Informe o c�digo do produto:");
										idProduct = Integer.parseInt(sc.next());
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
								} while (condition == true);

								System.out.println("Informe a nova descri��o do produto:");
								sc.nextLine();
								String newDescription = sc.nextLine();

								daoProduct.editProductDescription(idProduct, newDescription);

								break;

							case ALL:
								do {
									try {
										System.out.println("Informe o c�digo do produto:");
										idProduct = Integer.parseInt(sc.next());
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
								} while (condition == true);

								System.out.println("Informe o novo nome do produto:");
								sc.nextLine();
								newName = sc.nextLine();

								System.out.println("Informe o c�digo do produto:");
								newCode = sc.nextLine();

								System.out.println("Informe a nova descri��o do produto:");
								newDescription = sc.nextLine();

								daoProduct.editAllProductData(idProduct, newName, newCode, newDescription);

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
								System.out.println("Informe o c�digo do produto para excluir:");
								idProduct = Integer.parseInt(sc.next());
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
						} while (condition == true);

						daoProduct.removeProduct(idProduct);

						break;

					default:
						break;
					}
				} while (subMenu != SubMenu.EXIT);
				// final do subMenu para Produto
				break;

			// Inicia Menu escolha Pedido
			case ORDER:
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
				List<OrderItem> items = new ArrayList<OrderItem>();
				// inicia subMenu - escolher a��o CRUD Pedido - Inserir, Listar,
				// Editar, Excluir e Voltar Menu Principal.
				int idOrder = 0;
				do {
					do {
						try {
							System.out.println("Selecione uma das seguintes op��es:\n");
							System.out.println("1 - Inserir Pedido.");
							System.out.println("2 - Listar Pedidos.");
							System.out.println("3 - Editar Pedido.");
							System.out.println("4 - Excluir Pedido.");
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
					} while (condition == true);

					switch (subMenu) {

					case INSERT:
						// parei aqui
						System.out.println("Informe o c�digo do cliente:");
						int customerId = Integer.parseInt(sc.next());
						Date date = new Date();

						Customer customer = new Customer(customerId);
						
						for (int i = 0; i < items.size(); i++) {
							System.out.println("Informe o c�digo do produto:");
							int productId = Integer.parseInt(sc.next());
							
							System.out.println("Informe a quantidade do produto:");
							float quantity = sc.nextFloat();
							
							System.out.println("Informe o pre�o do produto:");
							float price = sc.nextFloat();

						}
						
						
						daoCustomerOrder.insertCustomerOrder(CustomerId, date, items);
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
						} while (condition == true);
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
						} while (condition == true);

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

						List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
						customerOrders = daoCustomerOrder.listCustomerOrders();
						customerOrders.sort(comparator);

						for (int i = 0; i < customerOrders.size(); i++) {
							System.out.println("Id: " + customerOrders.get(i).getIdCustomerOrders() + ", nome: "
									+ customerOrders.get(i).getName() + ", sobrenome: "
									+ customerOrders.get(i).getSurname() + ", telefone: "
									+ customerOrders.get(i).getPhoneNumber());
						}
						System.out.println("");

						break;

					case EDIT:

						// inicia subMenuEditCustomerOrder para edi��o;
						do {
							do {
								try {
									System.out.println("Selecione uma das seguintes op��es:\n");
									System.out.println("1 - Alterar o nome do cliente.");
									System.out.println("2 - Alterar o sobrenome do cliente.");
									System.out.println("3 - Alterar o telefone do cliente.");
									System.out.println("4 - Alterar o todos os dados do cliente.");
									System.out.println("5 - Voltar Menu Principal.");

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
							} while (condition == true);

							switch (subMenuEditCustomer) {

							case NAME:
								do {
									try {
										System.out.println("Informe o c�digo do cliente para alterar:");
										idCustomer = Integer.parseInt(sc.next());
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
								} while (condition == true);

								System.out.println("Informe o novo nome do cliente:");
								sc.nextLine();
								String newName = sc.nextLine();

								daoCustomer.editCustomerName(idCustomer, newName);

								break;

							case SURNAME:
								do {
									try {
										System.out.println("Informe o c�digo do cliente para alterar:");
										idCustomer = Integer.parseInt(sc.next());
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
								} while (condition == true);

								System.out.println("Informe o novo sobrenome do cliente:");
								sc.nextLine();
								String newSurname = sc.nextLine();

								daoCustomer.editCustomerSurname(idCustomer, newSurname);

								break;

							case PHONENUMBER:
								do {
									try {
										System.out.println("Informe o c�digo do cliente para alterar:");
										idCustomer = Integer.parseInt(sc.next());
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
								} while (condition == true);

								System.out.println("Informe o novo n�mero de telefone do cliente:");
								sc.nextLine();
								String newPhoneNumber = sc.nextLine();

								daoCustomer.editCustomerPhoneNumber(idCustomer, newPhoneNumber);

								break;

							case ALL:
								do {
									try {
										System.out.println("Informe o c�digo do cliente para alterar:");
										idCustomer = Integer.parseInt(sc.next());
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
								} while (condition == true);

								System.out.println("Informe o novo nome do cliente:");
								sc.nextLine();
								newName = sc.nextLine();

								System.out.println("Informe o novo sobrenome do cliente:");
								newSurname = sc.nextLine();

								System.out.println("Informe o novo n�mero de telefone do cliente:");
								newPhoneNumber = sc.nextLine();

								daoCustomer.editAllCustomerData(idCustomer, newName, newSurname, newPhoneNumber);

								break;
							}
						} while (subMenuEditCustomer != SubMenuEditCustomer.EXIT);
						// final subMenuEditCustomerOrder para edi��o
						break;

					case DELETE:
						do {
							try {
								System.out.println("Informe o c�digo do cliente para excluir:");
								idCustomer = Integer.parseInt(sc.next());
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
						} while (condition == true);

						daoCustomer.removeCustomer(idCustomer);

						break;

					default:
						break;
					}
					break;
				} while (subMenu != SubMenu.EXIT);

				// final do subMenu Order
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
		 * System.out.println("Informe a idade do usu�rio:"); int age = Integer.parseInt(sc.next());
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
		 * System.out.println("Informe o c�digo do usu�rio:"); int code = Integer.parseInt(sc.next());
		 * 
		 * System.out.println("Informe o nome completo do usu�rio:"); sc.nextLine();
		 * name = sc.nextLine();
		 * 
		 * System.out.println("Informe a idade do usu�rio:"); age = Integer.parseInt(sc.next());
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
		 * Integer.parseInt(sc.next());
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