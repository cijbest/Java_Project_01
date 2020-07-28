package db;

public class InsertUserTest {

	public static void main(String[] args) {

		Db<String, User> db = new UserDb("127.0.0.1", "db", "db");
		User user = new User("id11", "pwd11", "������");
		try {
			db.insert(user); // �Լ������� �����޼����� ���� ���� ������ ������ ������ �� �� ����.
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		
	}

}
