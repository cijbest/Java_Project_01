package battleground;

public class Kit extends Medicine {

   public Kit() {
      super();
   }

   public Kit(String name, int numItem, int numGauge) {
      super(name, numItem, numGauge);
   }

   @Override
   void doCure() {
      numGauge += 50;
      System.out.println("체력을 50만큼 회복했습니다. 현재 체력: " + numGauge);
   }

   @Override
   void getItem() {
      numItem += 1;
      System.out.println(name + "를 주웠습니다. " + name + "개수: " + numItem);
   }
   

   void throwItem() {
      numItem -= 1;
      System.out.println(name + "을 버립니다. "+name+"개수: "+numItem);
   }

   @Override
   public String toString() {
      return "Kit [numGauge=" + numGauge + ", name=" + name + ", numItem=" + numItem + "]";
   }

}