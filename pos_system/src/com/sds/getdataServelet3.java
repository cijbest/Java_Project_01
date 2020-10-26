package com.sds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class getdataServlet3
 */
@WebServlet({ "/getdataServlet3", "/getdata3" })
public class getdataServelet3 extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
    */
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ArrayList<Graph3> list = new ArrayList<>();
      ArrayList<Data3> list1 = new ArrayList<>();
      
      list1.add(new Data3("¾Æ¸Þ¸®Ä«³ë", 61.41, true, true));
      list1.add(new Data3("¶ó¶¼", 11.84, false, false));
      list1.add(new Data3("¸¶³¢¾Æ¶Ç", 10.85, false, false));
      list1.add(new Data3("ÇÖ ÃÝÄÚ", 4.67, false, false));
      list1.add(new Data3("Æ¼", 4.18, false, false));
      list1.add(new Data3("Other", 7.05, false, false));
            
      JSONArray ja1 = new JSONArray();            
      for(Data3 d:list1) {
         JSONObject obj1 = new JSONObject();
         obj1.put("name", d.getName());
         obj1.put("y", d.getY());
         obj1.put("sliced", d.isSliced());
         obj1.put("selected", d.isSelected());
         ja1.add(obj1);
      }
      
      list.add(new Graph3("ºñÀ²", true, ja1));
      
      JSONArray ja = new JSONArray();
      JSONObject obj = new JSONObject();
      for(Graph3 g:list) {
         obj.put("name", g.getName());
         obj.put("colorByPoint", g.getColorByPoint());
         obj.put("data", g.getData());
         ja.add(obj);
      }
      
      response.setContentType("text/json;charset=euc-kr");
      PrintWriter out = response.getWriter();
      out.print(ja.toJSONString());
      
      
   }
}
