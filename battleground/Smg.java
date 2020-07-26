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
