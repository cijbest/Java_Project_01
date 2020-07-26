package battleground;

public class Bandage extends Medicine {
   public Bandage() {
      super();
   }

   public Bandage(String name, int numItem, int numGauge) {
      super(name, numItem, numGauge);
   }

   @Override
   void doCure() {
      numGauge += 10;
      System.out.println("ü���� 10��ŭ ȸ���߽��ϴ�. ���� ü��: "+numGauge);
   }

   @Override
   void getItem() {
      numItem += 3;
      System.out.println(name + "�� �ֿ����ϴ�. "+name+"����: "+numItem);
   }
   
   void throwItem() {
      numItem -= 1;
      System.out.println(name + "�� �����ϴ�. "+name+"����: "+numItem);
   }

   @Override
   public String toString() {
      return "Bandage [numGauge=" + numGauge + ", name=" + name + ", numItem=" + numItem + "]";
   }
   

}