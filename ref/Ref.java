package ref;

public class Ref {
	String name;
	Tv tv; // ������ Tv�� ������ �ִ�.
	
	public Ref() {}
	public Ref(String name) {
		this.name = name;
	}
	public Ref(String name, Tv tv) {
		this.name = name;
		this.tv = tv;
	}
	public void setTv(Tv tv) {
		this.tv = tv;
	}
	public void on() {
		System.out.println("Ref On");
		tv.powerOn(); // tv ���� �ѱ�
	}
	public void off() {
		System.out.println("Ref Off");
		tv.powerOff();
	}
	@Override
	public String toString() {
		return "Ref [name=" + name + ", tv=" + tv + "]";
	}
	
}
