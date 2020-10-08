package comparators;

import java.util.Comparator;

import entities.Client;

public class DebtDescComparator implements Comparator<Client> {

	public int compare(Client client1, Client client2) {
		if (client1.getDebt() > client2.getDebt())
			return -1;

		if (client1.getDebt() < client2.getDebt())
			return 1;
		return 0;
	}
}