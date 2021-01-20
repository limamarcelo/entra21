package model.dao.user;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.user.User;

public class UserDAOSerializableImpl implements UserDAO {

	public ArrayList<User> readUsers() {

		FileInputStream archive;
		ArrayList<User> users = null;
		
		try {
			archive = new FileInputStream("db.txt");
			ObjectInputStream sc = new ObjectInputStream(archive);

			users = (ArrayList<User>) sc.readObject();

			sc.close();
			archive.close();
		} catch (FileNotFoundException e) {
			System.err.println("O arquivo De Usuários Não Existe.");
		} catch (IOException e) {
			System.err.println("Houve Um Erro Ao Ler O Arquivo De Usuários.");
		} catch (ClassNotFoundException e) {
			System.err.println("Houve Um Erro Ao Ler O Arquivo De Usuários.");
		}
		return users;
	}

	public void writeUsers(ArrayList<User> users) {
		FileOutputStream archive;

		try {
			archive = new FileOutputStream("db.txt");
			ObjectOutputStream write = new ObjectOutputStream(archive);

			write.writeObject(users);

			write.close();
			archive.close();
		} catch (FileNotFoundException e) {
			System.err.println("O arquivo De Usuários Não Existe.");
		} catch (IOException e) {
			System.err.println("Houve Um Erro Ao Ler O Arquivo De Usuários.");
		}
	}
}
