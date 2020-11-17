package control.comparator.username;

import java.util.Comparator;

import model.user.User;

public class UsernameAscendingComparator implements Comparator<User> {

	public int compare(User user1, User user2) {
		return user1.getName().compareTo(user2.getName());
	}
}