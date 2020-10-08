package comparators;

import java.util.Comparator;

import entities.Client;

public class AgeAscComparator implements Comparator<Client> {

	public int compare(Client client1, Client client2) {
		if (client1.getAge() > client2.getAge())
			return 1;

		if (client1.getAge() < client2.getAge())
			return -1;
		return 0;
	}
}