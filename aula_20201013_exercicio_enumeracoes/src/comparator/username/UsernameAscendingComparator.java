package comparator.username;

import java.util.Comparator;

import user.user;

public class UsernameAscendingComparator implements Comparator<user> {

	public int compare(user user1, user user2) {
		return user1.getName().compareTo(user2.getName());
	}
}