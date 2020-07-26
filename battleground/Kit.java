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
      System.out.println("ü���� 50��ŭ ȸ���߽��ϴ�. ���� ü��: " + numGauge);
   }

   @Override
   void getItem() {
      numItem += 1;
      System.out.println(name + "�� �ֿ����ϴ�. " + name + "����: " + numItem);
   }
   

   void throwItem() {
      numItem -= 1;
      System.out.println(name + "�� �����ϴ�. "+name+"����: "+numItem);
   }

   @Override
   public String toString() {
      return "Kit [numGauge=" + numGauge + ", name=" + name + ", numItem=" + numItem + "]";
   }

}