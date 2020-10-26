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

import controller.ItemController;
import frame.Controller;
import vo.Chart2;
import vo.Item;

@WebServlet({ "/getdataServlet", "/getdata" })
public class getdataServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
// Chart2 won't be used
   Controller<Integer, Item, Chart2> controller;
   
    public getdataServlet() {
        super();
        controller = new ItemController();  // ���⼭ �ε带 ������
    }
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      ArrayList<Item> list = new ArrayList<>();

      try {
           list = controller.get();
         } catch (Exception e) {
           e.printStackTrace();
         }
         
         JSONArray ja = new JSONArray();
         for(Item i : list) {
            JSONObject obj = new JSONObject();
            obj.put("id", i.getId());
            obj.put("name", i.getName());
            obj.put("price", i.getPrice());
            obj.put("img", i.getImg());
            obj.put("stock", i.getStock());
            ja.add(obj);
         }

         response.setContentType("text/json;charset=euc-kr");  // �ѱ� ���� ���� ����
         PrintWriter out = response.getWriter();
         out.print(ja.toJSONString());


   }

}