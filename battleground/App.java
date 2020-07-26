package battleground;

public class App {

	public static void main(String[] args) {

		Item vector = new Smg("Vector", 0, 30);
		Item awm = new Sr("Awm", 0, 7);

		vector.getItem();
		System.out.println("ÇöÀç ÃÑ °³¼ö : " + vector.numItem);
		System.out.println("ÃÑ¾Ë °³¼ö : " + ((Gun) vector).numBullet);
		((Smg) vector).doShoot();
		System.out.println("ÃÑ¾Ë °³¼ö : " + ((Gun) vector).numBullet);
		((Smg) vector).doReload();
		System.out.println("ÃÑ¾Ë °³¼ö : " + ((Gun) vector).numBullet);
		vector.throwItem();
		System.out.println("ÇöÀç ÃÑ °³¼ö : " + vector.numItem);

		awm.getItem();
		System.out.println("ÇöÀç ÃÑ °³¼ö : " + vector.numItem);

		Item i = new Bandage("ºØ´ë", 0, 100);
		System.out.println(i);
		i.getItem();
		i.getItem();
		((Bandage) i).doCure();
		((Bandage) i).throwItem();
		System.out.println(i);

		Item g = new Kit("±¸±Þ»óÀÚ", 0, 0);
		System.out.println(g);
		g.getItem();
		g.getItem();
		((Medicine) g).doCure();
		g.throwItem();
		System.out.println(g);

	}

}
