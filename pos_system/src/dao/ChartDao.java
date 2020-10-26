package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.Chart;
import vo.Chart2;

public class ChartDao extends Dao<Integer, Chart, Chart2> {

   
   @Override
   public void insert(Connection con, Chart v) throws Exception {
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
   public void update(Connection con, Chart v) throws Exception {
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
   public Chart select(Connection con, Integer k) throws Exception {
      Chart chart = null;
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
      return chart;
   }
   

   @Override
   public ArrayList<Chart> select(Connection con) throws Exception {
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      ArrayList<Chart> list = new ArrayList<>();
      try {
         pstmt = con.prepareStatement(Sql.userSelectAll);
         rset = pstmt.executeQuery();
         while (rset.next()) {
            String day = rset.getString("BUYDAY");
            String name = rset.getString("NAME");
            int sum = rset.getInt("SUM");
            Chart chart = new Chart(day, name, sum);
            list.add(chart);
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
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    ArrayList<Chart2> list = new ArrayList<>();
    try {
       pstmt = con.prepareStatement(Sql.sumSelect);
       rset = pstmt.executeQuery();
       while (rset.next()) {
          String month = rset.getString("MONTH");
          String name = rset.getString("NAME");
          int sum = rset.getInt("SUM");
          Chart2 chart = new Chart2(sum,month,name);
          list.add(chart);
       }
    } catch (Exception e) {
       throw e;
    } finally {
       close(rset);
       close(pstmt);
    }
    return list;
 }
}
