package comparator.age;

import java.util.Comparator;

import user.user;

public class AgeAscendingComparator implements Comparator<user> {

	public int compare(user user1, user user2) {

		if (user1.getAge() > user2.getAge())
			return 1;

		if (user1.getAge() < user2.getAge())
			return -1;

		return 0;
	}
}