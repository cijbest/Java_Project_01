package db;
/*
 * Db<String, User>를 사용해야 제네릭 타입으로 선언된 클래스들을 사용할 수 있다. 유의할 것 !!
 * 제네릭을 사용하지 않으면 리턴타입이 Object이므로 타입캐스팅을 해주어야 하는 상황이 발생한다.
 */
public class SelectUserTest {

	public static void main(String[] args) {

		Db<String, User> db = new UserDb("127.0.0.1", "db", "db");
		User user = null;
		try {
			user = db.select("id03"); // 이 부분이 Object 타입으로 리턴 될 수 있다.(제네릭 미사용 시)
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		System.out.println(user);
	}

}
