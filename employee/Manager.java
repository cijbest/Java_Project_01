package employee2;
/***********************************************************
 * private�� �ڽĿ��Ե� ������ ������� �ʴ´�.
 * protected�� ��ӵ� Ŭ������ ���� ��Ű�� ���� �ִ� ��� Ŭ�������� ������ ����Ѵ�.
 * �ƹ��͵� ���� ������ default�ε� ���� ��Ű�� �������� ����� �����ϴ�.
 ***********************************************************/
public class Manager extends Employee {
	
	double incentive;
	
	public Manager() {
	}
	public Manager(String name, String id,  double salary, String dept, double incentive) {
		super(name, id, salary, dept); // ���� Ŭ������ ������ �ڵ带 �̿�
		this.incentive = incentive;
	}
	
	
	// overriding (������) - �������� ����� �������� �����־�� �Ѵ�. 
	// (Polymorphism)������ : ��������δ� ������ ǥ���� �޶�����.
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
