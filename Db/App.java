package w0724;

public class App {

	public static void main(String[] args) {

		Db db = new UserDb("192.168.111.1", 1000);
		User user = new User("serom", "pwd01", "lee");
		try {
			db.insert(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			db.update(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			db.delete("001");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
