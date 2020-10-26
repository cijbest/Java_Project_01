package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Chart;
import vo.Item;

public abstract class Controller<K,V1,V2> {
	
	public Controller() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		String user = "db";
		String password = "db";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		Connection con = null; 
		try {
			con = 
			DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void register(V1 v) throws Exception;
	public abstract void remove(K k) throws Exception;
	public abstract void modify(V1 v) throws Exception;
	public abstract V1 get(K k) throws Exception;
	public abstract ArrayList<V1> get() throws Exception;
	public abstract ArrayList<V2> get_sum() throws Exception;
	
}
