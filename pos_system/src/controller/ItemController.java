package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ItemDao;
import frame.Controller;
import frame.Dao;
import vo.Chart2;
import vo.Item;

public class ItemController extends Controller<Integer, Item, Chart2> {
   
   Dao<Integer, Item, Chart2> dao;

   public ItemController() {
      dao = new ItemDao();
   }

   @Override
   public void register(Item v) throws Exception {
      Connection con = null;
      try {
         con = getConnection();
         dao.insert(con, v);
         con.commit();  // �� ���� ������ �� Ŀ����
      }catch(Exception e) {
         con.rollback();
         throw e;
      }finally {
         close(con);
      }
   }

   @Override
   public void remove(Integer k) throws Exception {
      Connection con = null;
      try {
         con = getConnection();
         dao.delete(con, k);
         con.commit();
      }catch(Exception e) {
         con.rollback();
         throw e;
      }finally {
         close(con);
      }
   }

   @Override
   public void modify(Item v) throws Exception {
      Connection con = null;
      try {
         con = getConnection();
         dao.update(con, v);
         con.commit();
      }catch(Exception e) {
         con.rollback();
         throw e;
      }finally {
         close(con);
      }
   }

   @Override
   public Item get(Integer k) throws Exception {
      Connection con = null;
      Item item = null;
      try {
         con = getConnection();
         item = dao.select(con, k);
      }catch(Exception e) {
         throw e;
      }finally {
         close(con);
      }
      return item;
   }

   @Override
   public ArrayList<Item> get() throws Exception {
      Connection con = null;
      ArrayList<Item> list = null;
      try {
         con = getConnection();
         list = dao.select(con);
      }catch(Exception e) {
         throw e;
      }finally {
         close(con);
      }
      return list;
   }

@Override
public ArrayList<Chart2> get_sum() throws Exception {
    Connection con = null;
    ArrayList<Chart2> list = null;
    try {
       con = getConnection();
       list = dao.getsum(con);
    }catch(Exception e) {
       throw e;
    }finally {
       close(con);
    }
    return list;
}
   
}