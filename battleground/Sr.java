package battleground;

public class Sr extends Gun {

	public Sr() {
	}
	public Sr(String name, int numItem, int numBullet) {
		super(name, numItem, numBullet);
	}

	@Override
	public void doShoot() {
		numBullet -= 1;
	}

	@Override
	public void doReload() {
		numBullet = 7;
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
