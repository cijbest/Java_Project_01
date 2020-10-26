package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ChartDao;
import frame.Controller;
import frame.Dao;
import vo.Chart;
import vo.Chart2;

public class ChartController extends Controller<Integer, Chart, Chart2> {
   
   Dao<Integer, Chart, Chart2> dao;

   public ChartController() {
      dao = new ChartDao();
   }

   @Override
   public void register(Chart v) throws Exception {
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
   public void modify(Chart v) throws Exception {
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
   public Chart get(Integer k) throws Exception {
      Connection con = null;
      Chart chart = null;
      try {
         con = getConnection();
         chart = dao.select(con, k);
      }catch(Exception e) {
         throw e;
      }finally {
         close(con);
      }
      return chart;
   }

   @Override
   public ArrayList<Chart> get() throws Exception {
      Connection con = null;
      ArrayList<Chart> list = null;
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