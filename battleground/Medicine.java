package battleground;

public abstract class Medicine extends Item {

   protected int numGauge;

   public Medicine() {
      super();
   }

   public Medicine(String name, int numItem, int numGauge) {
      super(name, numItem);
      this.numGauge = numGauge;
   }

   abstract void doCure();
   
}