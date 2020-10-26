package com.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getweatherServelet
 */
@WebServlet({ "/getweatherServelet", "/weather" })
public class getweatherServelet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
    */
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
//      SimpleDateFormat hr = new SimpleDateFormat("HHmm");
//      System.out.println(date.format(new Date()));
//      System.out.println(hr.format(new Date()));
      String urlstr = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey=gFar4DZvriJ4KIuxYxjE6U3gUs1Ncc%2Bkth0aR%2BarRua2Utd69J6IkDrsonuJ4dattUxu5BMwKIgtcJxfZdSZOw%3D%3D&pageNo=1&numOfRows=10&dataType=JSON&base_date="+date.format(new Date())+"&base_time=0800&nx=61&ny=125&";
      String jsonstr = getRequest(urlstr, "");
      response.setContentType("test/json;charset=euc-kr");
      PrintWriter out = response.getWriter();
      out.print(jsonstr);
   }

   public String getRequest(String url, String parameter) {

      try {
         String param = "{\"param\":\"" + parameter + "\"} ";
         // url�� �ν��Ͻ��� �����.
         URL uri = new URL(url);
         // HttpURLConnection �ν��Ͻ��� �����´�.
         HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
         // Web Method�� Post Ÿ��
         connection.setRequestMethod("GET");
         // ��û�Ѵ�. 200�̸� �����̴�.
         int code = connection.getResponseCode();
         if (code == 200) {
            // ���� �� body ������ stream�� �޴´�.
            try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
               String line;
               StringBuffer buffer = new StringBuffer();
               while ((line = input.readLine()) != null) {
                  buffer.append(line);
               }
               return buffer.toString();
            }
         }
         return code + "";
      } catch (Throwable e) {
         throw new RuntimeException(e);
      }
   }
}