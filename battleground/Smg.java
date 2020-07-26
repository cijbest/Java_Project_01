package battleground;

public class Smg extends Gun {

	public Smg() {
	}
	public Smg(String name, int numItem, int numBullet) {
		super(name, numItem, numBullet);
	}

	@Override
	public void doShoot() {
		numBullet -= 10;
	}

	@Override
	public void doReload() {
		numBullet = 30;
		System.out.println("�Ѿ��� ������ �߽��ϴ�.");
	}

	@Override
	void getItem() {
		if(numItem > 1) {
			System.out.println("�̹� ���� ������ �ֽ��ϴ�.");
		} else {
			System.out.println(name + "�� �ֿ����ϴ�.");
			numItem++;
		}
		
	}

	@Override
	void throwItem() {
		numItem--;
	}

}
