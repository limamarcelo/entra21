package control.comparator.age;

import java.util.Comparator;

import model.user.User;

public class AgeDescendingComparator implements Comparator<User> {

	public int compare(User user1, User user2) {

		if (user1.getAge() > user2.getAge())
			return -1;

		if (user1.getAge() < user2.getAge())
			return 1;

		return 0;
	}
}