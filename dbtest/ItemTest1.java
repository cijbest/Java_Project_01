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
		String sql = "SELECT * FROM ITEMS";
		PreparedStatement pstmt = null;  // �̷� ������ ����(null!!)
		try {
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 4. Result - ResultSet
		ResultSet rset = null;
		ArrayList<Item> list = new ArrayList<>();
		try {
			rset = pstmt.executeQuery(); // ������ ������� ����
			while(rset.next()) { // ���� ����Ʈ�� �� ó�� ���̺� ���ʿ� �����Ƿ� �ƹ��͵� ����Ű�� ���� �ʴ�.
				String id = rset.getString("ID"); // id �÷���  ù��° ��
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
		
		// ArrayList Ȯ��
		for(Item i : list) {
			System.out.println(i);
		}
	}

}
