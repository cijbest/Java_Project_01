package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frame.Controller;
import vo.Item;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet({ "/DispatcherServlet", "/dispatcher" })
public class DispatcherServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
    public DispatcherServlet() {
        super();        
    }

   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("EUC-KR");
      String uri = request.getRequestURI();
      String path = uri.substring(uri.lastIndexOf("/"));
      path = path.substring(1, path.lastIndexOf("."));
      
      String   next = "shopper.html";
      if(path.equals("getdata")) {
         next = path;
      }
      
      RequestDispatcher rd = request.getRequestDispatcher(next);
      rd.forward(request, response);
   }

}