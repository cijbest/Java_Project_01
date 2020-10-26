package com.sds;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph3 {
   
   private String name;
   private boolean colorByPoint;
   private ArrayList<Data3> data;
   
   private Graph3 () {      
   }

   public Graph3(String name, boolean colorByPoint, ArrayList<Data3> data) {
      super();
      this.name = name;
      this.colorByPoint = colorByPoint;
      this.data = data;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public boolean getColorByPoint() {
      return colorByPoint;
   }

   public void setColorByPoint(boolean colorByPoint) {
      this.colorByPoint = colorByPoint;
   }

   public Object getData() {
      return data;
   }

   public void setData(ArrayList<Data3> data) {
      this.data = data;
   }

   @Override
   public String toString() {
      return "Graph3 [name=" + name + ", colorByPoint=" + colorByPoint + ", data=" + data + "]";
   }

   

   
   
   
}