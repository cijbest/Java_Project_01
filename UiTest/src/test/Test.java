package test;

import java.util.ArrayList;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

public class Test {

	public static void main(String[] args) {

		Db<String, User> db = new UserDb("127.0.0.1", "db", "db");
		ArrayList<User> list = null;
		try {
			list = db.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(User u : list) {
			System.out.println(u);
		}
		
	}

}
