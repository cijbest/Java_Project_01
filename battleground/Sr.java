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
		System.out.println("총알을 재장전 했습니다.");
	}

	@Override
	void getItem() {
		if(numItem > 1) {
			System.out.println("이미 총을 가지고 있습니다.");
		} else {
			System.out.println(name + "을 주웠습니다.");
			numItem++;
		}
		
	}

	@Override
	void throwItem() {
		numItem--;
	}

}
