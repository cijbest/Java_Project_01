package db;

public class InsertUserTest {

	public static void main(String[] args) {

		Db<String, User> db = new UserDb("127.0.0.1", "db", "db");
		User user = new User("id11", "pwd11", "공말숙");
		try {
			db.insert(user); // 함수에서는 오류메세지를 던져 주지 않으면 오류가 났는지 알 수 없다.
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		
	}

}
