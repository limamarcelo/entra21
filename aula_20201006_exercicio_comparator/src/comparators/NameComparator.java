package comparators;

import java.util.Comparator;

import entities.Client;

public class NameComparator implements Comparator<Client> {

	public int compare(Client cliente1, Client cliente2) {
		return cliente1.getName().compareTo(cliente2.getName());
	}
}