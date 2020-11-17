package model.dao.user;

import java.util.ArrayList;

import model.user.User;

public interface UserDAO {
	ArrayList<User> readUsers();
	void writeUsers(ArrayList<User> users);
}
