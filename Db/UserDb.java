package w0724;

public class UserDb extends Db<String, User> {

	public UserDb() {
		super();
	}

	public UserDb(String ip, int port) {
		super(ip, port);
	}

	@Override
	public void insert(User v) throws Exception {
		connect();
		if(v.getId().equals("serom")) {
			close();
			throw new Exception("Duplicated ID.."); // exception 떨어지면 밑의 문맥으로 안 내려가서 close할 시간이 없음
		}
		System.out.println("Inserted : " + v);
		close();		
	}

	@Override
	public void update(User v) throws Exception {
		connect();
		if(v.getId().equals("serom")) {
			close();
			throw new Exception("Duplicated ID.."); // exception 떨어지면 밑의 문맥으로 안 내려가서 close할 시간이 없음
		}
		System.out.println("Updated : " + v);
		close();		
	}

	@Override
	public void delete(String k) throws Exception {
		connect();
		if(k.equals("001")) {
			close();
			throw new Exception("Not Exist ID.."); // exception 떨어지면 밑의 문맥으로 안 내려가서 close할 시간이 없음
		}
		System.out.println("Deleted : " + k);
		close();		
	}

}
