package frame;

public class Sql {

   // Item SQL
   public static String itemInsert = "INSERT INTO CAFE_PRODUCTS VALUES(ITEM_SEQ.NEXTVAL,?,?,?,?)";
   public static String itemUpdate = "UPDATE CAFE_PRODUCTS SET NAME=?, PRICE=? WHERE PRODUCT_ID=?";
   public static String itemDelete = "DELETE FROM CAFE_PRODUCTS WHERE PRODUCT_ID =?";
   public static String itemSelect = "SELECT * FROM CAFE_PRODUCTS WHERE PRODUCT_ID =?";
   public static String itemSelectAll = "SELECT * FROM CAFE_PRODUCTS ORDER BY PRODUCT_ID ASC";

   // Chart SQL
   public static String userInsert = "INSERT INTO CHART_DATAS VALUES(?,?,?)";
   public static String userUpdate = "UPDATE CHART_DATAS SET PWD=?, NAME=? WHERE ID=?";
   public static String userDelete = "DELETE FROM CHART_DATAS WHERE ID=?";
   public static String userSelect = "SELECT * FROM CHART_DATAS WHERE ID=?";
   public static String userSelectAll = "SELECT * FROM CHART_DATAS ORDER BY NAME ASC";

   public static String sumSelect = "SELECT SUM(SUM) AS SUM, SUBSTR(BUYDAY,1,6) AS MONTH, NAME FROM CHART_DATAS GROUP BY SUBSTR(BUYDAY,1,6), NAME ORDER BY 2,3";
}