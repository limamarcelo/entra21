package comparator.customer.id;

import java.util.Comparator;

import model.customer.Customer;
//Qualquer comparador pode ser substituído simplesmente pelo select direto no banco de dados.
//feito desta forma por desafiar-se e fixar conteúdo.
public class IdAscendingComparatorCustomer implements Comparator<Customer> {

	public int compare(Customer customer1, Customer customer2) {

		if (customer1.getId() > customer2.getId())
			return 1;

		if (customer1.getId() < customer2.getId())
			return -1;

		return 0;
	}
}