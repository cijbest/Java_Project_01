package db;

public class UpdateUserTest {

	public static void main(String[] args) {

		Db db = new UserDb("127.0.0.1", "db", "db");
		User user = new User("id11", "pwd77", "������");
		try {
			db.update(user); // �Լ������� �����޼����� ���� ���� ������ ������ ������ �� �� ����.
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		
	}

}
