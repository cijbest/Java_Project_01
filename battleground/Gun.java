package battleground;

public abstract class Gun extends Item{

	protected int numBullet;

	public Gun() {
	}

	public Gun(String name, int numItem, int numBullet) {
		super(name, numItem);
		this.numBullet = numBullet;
	}


	public abstract void doShoot();
	public abstract void doReload();
}
