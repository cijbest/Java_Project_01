package employee2;
/***********************************************************
 * private은 자식에게도 접근을 허용하지 않는다.
 * protected는 상속된 클래스와 같은 패키지 내에 있는 모든 클래스에게 접근을 허용한다.
 * 아무것도 쓰지 않으면 default인데 같은 패키지 내에서만 사용이 가능하다.
 ***********************************************************/
public class Manager extends Employee {
	
	double incentive;
	
	public Manager() {
	}
	public Manager(String name, String id,  double salary, String dept, double incentive) {
		super(name, id, salary, dept); // 상위 클래스의 생성자 코드를 이용
		this.incentive = incentive;
	}
	
	
	// overriding (재정의) - 상위에서 사용한 리턴형식 지켜주어야 한다. 
	// (Polymorphism)다형성 : 언어적으로는 같지만 표현은 달라진다.
	public double annSalary() {
		double ann = 0.0;
		ann = super.annSalary() + this.incentive;
		return ann;
	}
	@Override
	public String toString() {
		return "Manager : " + super.toString() + " " + incentive;
	}
	
	
	
}
