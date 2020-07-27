package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCTest2 {

	public static void main(String[] args) {

		// JDBC(Java Database Connectivity) Programming
		// 1. Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // OracleDriver�� ���ڴ�! 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver Not Found !");
		} 
		// 2. Connection
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // ��Ģ !
		int port = 1521;
		String dbid = "db";
		String dbpwd = "db";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, dbid, dbpwd);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Not Connection !");
		}
		// 3. SQL - PreparedStatement
		String sql = "SELECT * FROM USERS WHERE ID=?";
		PreparedStatement pstmt = null;  // �̷� ������ ����(null!!)
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "id02"); // ?�� String���� �ְڴ�.(ù��° ?�ڸ�)
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 4. Result - ResultSet
		ResultSet rset = null;
		User user = null;
		try {
			rset = pstmt.executeQuery();
			rset.next(); // �� ĭ �̵����־� ���� ����Ű���� �Ѵ�.
			String id = rset.getString("ID");
			String pwd = rset.getString("PWD");
			String name = rset.getString("NAME");
			user = new User(id, pwd, name);
		} catch (SQLException e1) {
			System.out.println("ID Not Found ..");
			e1.printStackTrace();
		}
		
		// 5. Close
		try { 
			rset.close();
			pstmt.close();
			con.close();
			System.out.println("End Program..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(user);
		
		
	}

}
