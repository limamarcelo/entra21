package comparator.name;

import java.util.Comparator;

import user.user;

public class NameDescendingComparator implements Comparator<user> {

	public int compare(user user1, user user2) {
		return user1.getName().compareTo(user2.getName()) * -1;
	}
}