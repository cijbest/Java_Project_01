package db;

import java.util.ArrayList;

public class SelectAllUserTest {

	public static void main(String[] args) {

		Db<String, User> db = new UserDb("127.0.0.1", "db", "db");
		ArrayList<User> list = new ArrayList<>();
		try {
			list = db.select();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		for(User u : list) {
			System.out.println(u);
		}
	}

}
