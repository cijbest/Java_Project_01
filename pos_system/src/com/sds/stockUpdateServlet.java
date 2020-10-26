package com.sds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ItemController;
import frame.Controller;
import vo.Chart2;
import vo.Item;

@WebServlet({ "/StockUpdateServlet", "/updatedata" })
public class stockUpdateServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   Controller<Integer, Item, Chart2> controller;

   public stockUpdateServlet() {
      super();
      controller = new ItemController();
   }

   protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      String cnt[] = request.getParameterValues("cnt");
      //System.out.println(Arrays.toString(cnt)); 

      ArrayList<Item> list = null;
      try {
         list = controller.get();
      } catch (Exception e1) {
         e1.printStackTrace();
      }
      
      int n = 0;
      for(Item i : list) {
         int result = i.getStock() - Integer.parseInt(cnt[n++]);
         i.setStock(result);
         
         try {
            controller.modify(i);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

   }

}