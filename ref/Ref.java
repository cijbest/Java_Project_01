package ref;

public class Ref {
	String name;
	Tv tv; // 냉장고는 Tv를 가지고 있다.
	
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
		tv.powerOn(); // tv 같이 켜기
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
