package db;

public class UpdateUserTest {

	public static void main(String[] args) {

		Db db = new UserDb("127.0.0.1", "db", "db");
		User user = new User("id11", "pwd77", "폰말숙");
		try {
			db.update(user); // 함수에서는 오류메세지를 던져 주지 않으면 오류가 났는지 알 수 없다.
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		
	}

}
