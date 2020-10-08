package comparators;

import java.util.Comparator;

import entities.Client;

public class CpfComparator implements Comparator<Client> {

	public int compare(Client cliente1, Client cliente2) {
		return cliente1.getCpf().compareTo(cliente2.getCpf());
	}
}