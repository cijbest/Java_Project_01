package db;

/*
  *    ★ 상속 받아 쓰는 클래스의 함수 예외처리 시 반드시 " throw e "로 예외를 던져주어야 한다. ★
 * 함수에서는 오류메세지를 던져 주지 않으면 오류가 났는지 알 수 없기 때문에 
 * 함수 안에서 에러가 발생하면 예외를 던져주어 에러 처리를 할 수 있도록 도와준다.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UserDb extends Db<String, User> {

	public UserDb() {
		super();
	}

	public UserDb(String ip, String dbid, String dbpwd) {
		super(ip, dbid, dbpwd);
	}

	@Override
	public void insert(User v) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.userInsert);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.executeUpdate(); // 구문이 잘못되서 오류가 날 수 있는데 이 때 close 처리가 힘드므로 finally 사용
		} catch (Exception e) { // 여기는  exception이 일어나면 들어오는 곳
			//System.out.println("----"); // OK도 함께 뜨므로 프린트 구문을 쓰지 않고 예외처리를 해주어야 한다.
			throw e; //★ UI에게 에러를 던져주겠다.
		} finally {
			close(pstmt);
			close(con);
		}

	}

	@Override
	public void delete(String k) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.userDelete);
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate(); //★ 아이디가 없는데도 오류가 안 날 때 result값 받아오는 방법으로 처리
			if(result == 0) {
				throw new Exception(); // 강제로 예외 처리
			}
		} catch (Exception e) { 
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public void update(User v) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.userUpdate);
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getId());
			pstmt.executeUpdate(); 
		} catch (Exception e) { 
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public User select(String k) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User user = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.userSelect);
			pstmt.setString(1, k);
			rset = pstmt.executeQuery();
			rset.next();
			String id = rset.getString("ID");
			String pwd = rset.getString("PWD");
			String name = rset.getString("NAME");
			user = new User(id, pwd, name);
		} catch (Exception e) { 
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
		return user;
	}

	@Override
	public ArrayList<User> select() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> list = new ArrayList<>();

		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.userSelectAll);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String id = rset.getString("ID");
				String pwd = rset.getString("PWD");
				String name = rset.getString("NAME");
				User user = new User(id, pwd, name);
				list.add(user);
			}
		} catch (Exception e) { 
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
		return list;
	}

}
