package employee2;

public class Employee {
	private String id;
	private String name;	
	private double salary;
	private String dept;
	
	public Employee() {
	}
	public Employee(String name, String id, double salary, String dept) {
		this.name = name;
		this.id = id;
		if(salary < 0) {
			salary = 0;
		}
		this.salary = salary;
		this.dept = dept;
	}
	public double annSalary() {
		double ann = 0.0;
		ann = this.salary * 12;
		return ann;
	}
	public double taxSalary(){ // 세금 계산한 연봉
		double ann = 0.0;
		ann = this.salary * 12 * (1 - 0.022);
		return ann;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dept=" + dept + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
}
