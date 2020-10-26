package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.Chart2;
import vo.Item;

public class ItemDao extends Dao<Integer, Item, Chart2> {

   
   @Override
   public void insert(Connection con, Item v) throws Exception {
      /*
      PreparedStatement pstmt = null;
      try {
         pstmt = con.prepareStatement(Sql.itemInsert);
         pstmt.setString(1, v.getName());
         pstmt.setInt(2, v.getPrice());
         pstmt.executeUpdate();
      } catch (Exception e) {
         throw e;
      } finally {
         close(pstmt);
      }
      */

   }

   @Override
   public void update(Connection con, Item v) throws Exception {
      /*
      PreparedStatement pstmt = null;
      try {
         pstmt = con.prepareStatement(Sql.itemUpdate);
         pstmt.setString(1, v.getName());
         pstmt.setInt(2, v.getPrice());
         pstmt.setInt(3, v.getId());
         pstmt.executeUpdate();
      } catch (Exception e) {
         throw e;
      } finally {
         close(pstmt);
      }
      */
   }

   @Override
   public void delete(Connection con, Integer k) throws Exception {
      /*
      PreparedStatement pstmt = null;
      try {
         pstmt = con.prepareStatement(Sql.itemDelete);
         pstmt.setInt(1, k);
         int result = pstmt.executeUpdate();
         if(result == 0) {
            throw new Exception();
         }
      } catch (Exception e) {
         throw e;
      } finally {
         close(pstmt);
      }
      */
   }


   @Override
   public Item select(Connection con, Integer k) throws Exception {
      Item item = null;
      /*
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      Item item = null;
      try {
         pstmt = con.prepareStatement(Sql.itemSelect);
         pstmt.setInt(1, k);
         rset = pstmt.executeQuery();
         rset.next();
         int id = rset.getInt("ID");
         String name = rset.getString("NAME");
         int price = rset.getInt("PRICE");
         Date regdate = rset.getDate("REGDATE");
         item = new Item(id, name, price, regdate);
      } catch (Exception e) {
         throw e;
      } finally {
         close(rset);
         close(pstmt);
      }
      return item;
      */
      return item;
   }
   
   

   @Override
   public ArrayList<Item> select(Connection con) throws Exception {
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      ArrayList<Item> list = new ArrayList<>();
      try {
         pstmt = con.prepareStatement(Sql.itemSelectAll);
         rset = pstmt.executeQuery();
         while (rset.next()) {
            String id = rset.getString("PRODUCT_ID");
            String name = rset.getString("NAME");
            int price = rset.getInt("PRICE");
            int stock = rset.getInt("STOCK");
            String img = rset.getString("PICTURE");
            System.out.println(id + " " + name);
            Item item = new Item(id, name, price, stock, img);
            list.add(item);
         }
      } catch (Exception e) {
         throw e;
      } finally {
         close(rset);
         close(pstmt);
      }
      return list;
   }

@Override
public ArrayList<Chart2> getsum(Connection con) throws Exception {
	// TODO Auto-generated method stub
	return null;
}


}