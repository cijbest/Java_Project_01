package employee2;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee("Lee", "11", 500, "M");
		Manager m = new Manager("Lee", "11", 500, "M", 100);
		Sales s = new Sales("Lee", "11", 500, "M", "seoul", 50);
		
		System.out.println(e);
		System.out.println(m);
		System.out.println(s);
		
		System.out.println(e.annSalary());
		System.out.println(m.annSalary());
		System.out.println(s.annSalary());
		System.out.println("--------");
		System.out.println(e.taxSalary());
		System.out.println(m.taxSalary());
		System.out.println(s.taxSalary());
	}

}
