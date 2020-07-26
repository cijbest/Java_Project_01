package battleground;

public abstract class Item {
   protected String name;
   protected int numItem;
   
   public Item() {
   }

   public Item(String name, int numItem) {
      this.name = name;
      this.numItem = numItem;
   }
   
   abstract void getItem();
   abstract void throwItem();

}