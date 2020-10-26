package com.sds;

public class Data3 {
   private String name;
   private double y;
   private boolean sliced;
   private boolean selected;
   public Data3() {
      super();
   }
   public Data3(String name, double y, boolean sliced, boolean selected) {
      super();
      this.name = name;
      this.y = y;
      this.sliced = sliced;
      this.selected = selected;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public double getY() {
      return y;
   }
   public void setY(float y) {
      this.y = y;
   }
   public boolean isSliced() {
      return sliced;
   }
   public void setSliced(boolean sliced) {
      this.sliced = sliced;
   }
   public boolean isSelected() {
      return selected;
   }
   public void setSelected(boolean selected) {
      this.selected = selected;
   }
   @Override
   public String toString() {
      return "Data3 [name=" + name + ", y=" + y + ", sliced=" + sliced + ", selected=" + selected + "]";
   }
   
   
}