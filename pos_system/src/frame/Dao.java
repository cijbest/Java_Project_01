package frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao<K,V1, V2> {
	public void close(ResultSet rset) {
		if(rset != null) {
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void insert(Connection con, V1 v) throws Exception;
	public abstract void delete(Connection con, K k) throws Exception;
	public abstract void update(Connection con, V1 v) throws Exception;
	public abstract V1 select(Connection con, K k) throws Exception;
	public abstract ArrayList<V1> select(Connection con) throws Exception;
	public abstract ArrayList<V2> getsum(Connection con) throws Exception;
	
}
