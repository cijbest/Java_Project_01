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

import controller.ChartController;
import frame.Controller;
import vo.Chart;
import vo.Chart2;

/**
 * Servlet implementation class getdataServelet4
 */
@WebServlet({ "/getdataServelet4", "/getdata4" })
public class getdataServelet4 extends HttpServlet {
   private static final long serialVersionUID = 1L;
   Controller<Integer, Chart, Chart2> controller;

   public getdataServelet4() {
	super();
	controller = new ChartController();
}
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ArrayList<Chart2> list = new ArrayList<>();
       ArrayList<Chart2> list2 = new ArrayList<>();
       try {
		list = controller.get_sum();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
       
       String p1_month_sales = "";
       String p2_month_sales = "";
       String p3_month_sales = "";
       String p4_month_sales = "";
       String p5_month_sales = "";
       String p6_month_sales = "";
       
       String p1 = "¾Æ¸Þ¸®Ä«³ë";
       String p2 = "¶ó¶¼";
       String p3 = "¸¶³¢¾Æ¶Ç";
       String p4 = "ÇÖ ÃÝÄÚ";
       String p5 = "Æ¼";
       String p6 ="Çã´Ïºê·¹µå";
       
       for(Chart2 j: list) {
    	   if(j.getName().equals(p1)) {
    		   p1_month_sales = p1_month_sales+ j.getSum()+",";
    	   }else if(j.getName().equals(p2)) {
    		   p2_month_sales = p2_month_sales+ j.getSum()+",";
    	   }else if(j.getName().equals(p3)) {
    		   p3_month_sales = p3_month_sales+ j.getSum()+",";
    	   }else if(j.getName().equals(p4)) {
    		   p4_month_sales = p4_month_sales+ j.getSum()+",";
    	   }else if(j.getName().equals(p5)) {
    		   p5_month_sales = p5_month_sales+ j.getSum()+",";
    	   }else if(j.getName().equals(p6)) {
    		   p6_month_sales = p6_month_sales+ j.getSum()+",";
    	   }else {
    		   System.out.println("getdataservlet4 error...");
    	   }
       }
       
       String[] temp1 = {p1,p2,p3,p4,p5,p6};
       String[] temp2 = {p1_month_sales,p2_month_sales,p3_month_sales,p4_month_sales,p5_month_sales,p6_month_sales};
       System.out.println("temp1: "+temp1[0]);
       System.out.println("temp2: "+temp2[0]);
       
       JSONArray ja = new JSONArray();
       for(int i=0; i<6;i++) {
            JSONObject obj = new JSONObject();
            obj.put("sum", temp2[i]);
            obj.put("name", temp1[i]);
            ja.add(obj);
       }
         
       response.setContentType("text/json;charset=euc-kr");  // ï¿½Ñ±ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
       PrintWriter out = response.getWriter();
       out.print(ja.toJSONString());

   }

}