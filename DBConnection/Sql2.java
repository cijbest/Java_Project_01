package db;

public class Sql2 { // sql문만 관리
	public static String productInsert = "INSERT INTO PRODUCTS VALUES(?,?,?,?,SYSDATE)";
	public static String productDelete = "DELETE FROM PRODUCTS WHERE ID = ?";
	public static String productUpdate = "UPDATE PRODUCTS SET NAME=?, PRICE=? WHERE ID=?";
	public static String productSelect = "SELECT * FROM PRODUCTS WHERE ID=?";
	public static String productSelectAll = "SELECT * FROM PRODUCTS";
}
