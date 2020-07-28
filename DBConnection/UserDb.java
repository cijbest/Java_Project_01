package db;

/*
  *    �� ��� �޾� ���� Ŭ������ �Լ� ����ó�� �� �ݵ�� " throw e "�� ���ܸ� �����־�� �Ѵ�. ��
 * �Լ������� �����޼����� ���� ���� ������ ������ ������ �� �� ���� ������ 
 * �Լ� �ȿ��� ������ �߻��ϸ� ���ܸ� �����־� ���� ó���� �� �� �ֵ��� �����ش�.
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
			pstmt.executeUpdate(); // ������ �߸��Ǽ� ������ �� �� �ִµ� �� �� close ó���� ����Ƿ� finally ���
		} catch (Exception e) { // �����  exception�� �Ͼ�� ������ ��
			//System.out.println("----"); // OK�� �Բ� �߹Ƿ� ����Ʈ ������ ���� �ʰ� ����ó���� ���־�� �Ѵ�.
			throw e; //�� UI���� ������ �����ְڴ�.
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
			int result = pstmt.executeUpdate(); //�� ���̵� ���µ��� ������ �� �� �� result�� �޾ƿ��� ������� ó��
			if(result == 0) {
				throw new Exception(); // ������ ���� ó��
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
