package comparator.password;

import java.util.Comparator;

import user.user;

public class PasswordDescendingComparator implements Comparator<user> {

	public int compare(user user1, user user2) {
		return user1.getPassword().compareTo(user2.getPassword()) * -1;
	}
}