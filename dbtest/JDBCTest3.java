package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCTest3 {

	public static void main(String[] args) {

		// JDBC(Java Database Connectivity) Programming
		// 1. Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // OracleDriver를 쓰겠다! 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver Not Found !");
		} 
		// 2. Connection
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // 규칙 !
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
		String sql = "INSERT INTO USERS VALUES(?,?,?)";
		PreparedStatement pstmt = null;  // 이런 식으로 쓰자(null!!)
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "id03"); 
			pstmt.setString(2, "pwd03");
			pstmt.setString(3, "김말숙");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 4. Result - ResultSet
		int result = 0;
		try {
			result = pstmt.executeUpdate(); // insert가 하나면 1이 날라옴, 아무것도 insert 안되면 0이 넘어옴
			System.out.println(result);
		} catch (SQLException e1) {
			System.out.println("Duplicated ID ..");
			e1.printStackTrace();
		}
		System.out.println(result);
		
		// 5. Close
		try { 
			
			pstmt.close();
			con.close();
			System.out.println("End Program..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
