package control.comparator.password;

import java.util.Comparator;

import model.user.User;

public class PasswordAscendingComparator implements Comparator<User> {

	public int compare(User user1, User user2) {
		return user1.getPassword().compareTo(user2.getPassword());
	}
}