package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemTest1 {

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
		String sql = "SELECT * FROM ITEMS";
		PreparedStatement pstmt = null;  // 이런 식으로 쓰자(null!!)
		try {
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 4. Result - ResultSet
		ResultSet rset = null;
		ArrayList<Item> list = new ArrayList<>();
		try {
			rset = pstmt.executeQuery(); // 쿼리의 결과값이 들어옴
			while(rset.next()) { // 현재 포인트가 맨 처음 테이블 위쪽에 있으므로 아무것도 가리키고 있지 않다.
				String id = rset.getString("ID"); // id 컬럼의  첫번째 값
				String pwd = rset.getString("PWD");
				int price = rset.getInt("PRICE");
				Item item = new Item(id, pwd, price);
				list.add(item);
			}
		} catch (SQLException e1) {
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
		
		// ArrayList 확인
		for(Item i : list) {
			System.out.println(i);
		}
	}

}
