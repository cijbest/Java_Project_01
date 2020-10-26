package vo;

import java.sql.Date;

public class Chart {
   private String regdate;
   private String name;
   private int sum;
   
   public Chart() {
   }

   public Chart(String regdate, String name, int sum) {
      this.regdate = regdate;
      this.name = name;
      this.sum = sum;
   }

   public String getRegdate() {
      return regdate;
   }

   public void setRegdate(String regdate) {
      this.regdate = regdate;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getSum() {
      return sum;
   }

   public void setSum(int sum) {
      this.sum = sum;
   }

   @Override
   public String toString() {
      return "Chart [regdate=" + regdate + ", name=" + name + ", sum=" + sum + "]";
   }
   
   
   

}