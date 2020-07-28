package db;
/*
 * Db<String, User>�� ����ؾ� ���׸� Ÿ������ ����� Ŭ�������� ����� �� �ִ�. ������ �� !!
 * ���׸��� ������� ������ ����Ÿ���� Object�̹Ƿ� Ÿ��ĳ������ ���־�� �ϴ� ��Ȳ�� �߻��Ѵ�.
 */
public class SelectUserTest {

	public static void main(String[] args) {

		Db<String, User> db = new UserDb("127.0.0.1", "db", "db");
		User user = null;
		try {
			user = db.select("id03"); // �� �κ��� Object Ÿ������ ���� �� �� �ִ�.(���׸� �̻�� ��)
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		System.out.println(user);
	}

}
